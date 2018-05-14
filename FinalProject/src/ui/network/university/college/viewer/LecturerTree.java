package ui.network.university.college.viewer;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;
import biz.role.producerRole.CollegeLecturerRole;
import biz.video.Video;

import javax.swing.*;
import javax.swing.tree.*;
import java.util.HashSet;
import java.util.Map;

public class LecturerTree extends JTree {
    class LecturerWithNumber {
        private Person lecturer;
        private long number;

        public LecturerWithNumber(Person lecturer) {
            this.lecturer = lecturer;
            this.number = getVideoNumber(lecturer);
        }

        @Override
        public String toString() {
            return String.format("%s (%d)", lecturer, number);
        }

        public Person getLecturer() {
            return lecturer;
        }
    }

    private long getVideoNumber(Person lecturer) {
        HashSet<Account> accountSet = lecturer.getOrg().getPersonCatalog().getPersonAccountMap().get(lecturer);
        return lecturer.getOrg().getEnterprise().getNetwork().getVideoCatalog().getVideoArrayList().stream()
                .filter(Video::canView)
                .filter(video -> accountSet.contains(video.getUploaderAccount())).count();
    }

    public LecturerTree(Account account) {
        super();
        Network network = account.getOrg().getEnterprise().getNetwork();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(network.toString());

        DefaultMutableTreeNode universityVideosNode = new DefaultMutableTreeNode("University Videos");
        root.add(universityVideosNode);
        for (UniverseCollegeOrganization college: network.getUniversity().getCollegeCatalog().getOrganizations()) {
            String nodeName = college.getName();
            if (account.getOrg().equals(college)) {
                nodeName += " (My College)";
            }
            DefaultMutableTreeNode collegeNode = new DefaultMutableTreeNode(nodeName);
            universityVideosNode.add(collegeNode);
            CollegeLecturerRole role = college.getCollegeLecturerRole();
            for (Map.Entry<Person, HashSet<Account>> e: college.getPersonCatalog().getPersonAccountMap().entrySet()) {
                if (e.getValue().stream().anyMatch(a -> a.getRole().equals(role))) {
                    collegeNode.add(new DefaultMutableTreeNode(new LecturerWithNumber(e.getKey())));
                }
            }  // TODO: order by video number
        }

        DefaultMutableTreeNode ECOVideoNode = new DefaultMutableTreeNode("EC Videos");
        root.add(ECOVideoNode);

        DefaultTreeModel model = new DefaultTreeModel(root);
        setModel(model);
        getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        ((DefaultTreeCellRenderer) cellRenderer).setLeafIcon(null);  // TODO: use a profile pic thumbnail
    }
}
