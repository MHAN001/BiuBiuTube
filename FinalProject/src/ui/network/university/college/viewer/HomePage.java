/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.viewer;

import biz.account.Account;
import biz.person.Person;
import biz.video.Video;
import biz.video.VideoTag;
import ui.components.ChildComponent;
import ui.components.ParentUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author hezj
 */
public class HomePage extends JPanel implements ChildComponent {
    private ParentUI parent;
    private Account account;
    private JSplitPane splitPane;
    private JPanel rightContainer;
    private LecturerTree tree;
    private TagList tagList;
    private JButton btnShowTop;
    private State state;
    private VideoTag showingTag;
    private Person showingLecturer;

    private enum State {
        LecturerVideos, TagVideos, TopVideos
    }

    public HomePage(ParentUI parent, Account account) {
        this.parent = parent;
        this.account = account;
        initComponents();
    }

    private void initComponents() {
        setSize(1000, 700);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        btnShowTop = new JButton("<< Show Top Videos");
        btnShowTop.addActionListener(e -> showTopVideos());

        splitPane = new JSplitPane();
        splitPane.setEnabled(false);
        splitPane.setDividerLocation(200);
        add(splitPane);

        tree = new LecturerTree(account);
        tagList = new TagList(account);
        JTabbedPane tab = new JTabbedPane();
        tab.addTab("Lecturer Tree", tree);
        tab.addTab("Tag List", tagList);
        JScrollPane leftScroll = new JScrollPane(tab);
        leftScroll.setMaximumSize(new Dimension((int) leftScroll.getMaximumSize().getWidth(), 650));
        splitPane.setLeftComponent(leftScroll);

        tree.addTreeSelectionListener(this::treeNodeSelected);
        tagList.addListSelectionListener(this::tagSelected);

        showTopVideos();
    }

    private void showTopVideos() {
        rightContainer = new JPanel();
        rightContainer.setLayout(new BorderLayout());

        JLabel lblTitle = new JLabel("Top 10 Videos", JLabel.CENTER);
        Font f = lblTitle.getFont();
        lblTitle.setFont(new Font(f.getName(), Font.BOLD, 30));
        rightContainer.add(lblTitle, BorderLayout.PAGE_START);

        JPanel mostViews = new JPanel();
        JPanel mostUpVotes = new JPanel();

        JTabbedPane topTab = new JTabbedPane();
        topTab.addTab("Most Views", mostViews);
        topTab.addTab("Most Up Votes", mostUpVotes);

        JScrollPane rightScroll = new JScrollPane(topTab);
        splitPane.setRightComponent(rightContainer);
        rightContainer.add(rightScroll);

        mostViews.setBackground(new Color(153, 153, 153));
        mostViews.setLayout(new BoxLayout(mostViews, BoxLayout.Y_AXIS));
        ArrayList<Video> videoArrayList = account.getOrg().getEnterprise().getNetwork().getVideoCatalog().getVideoArrayList();
        populateVideoBoxes(
                videoArrayList
                        .stream()
                        .sorted(Comparator.comparingInt((Video v) -> v.getVoteCatalog().getVoteArrayList().size()).reversed())
                        .limit(10),
                mostViews
        );

        mostUpVotes.setBackground(new Color(153, 153, 153));
        mostUpVotes.setLayout(new BoxLayout(mostUpVotes, BoxLayout.Y_AXIS));
        populateVideoBoxes(
                videoArrayList
                        .stream()
                        .sorted(Comparator.comparingInt((Video v) -> v.getViewHistoryCatalog().getViewHistoryArrayList().size()).reversed())
                        .limit(10),
                mostUpVotes
        );
        state = State.TopVideos;
    }

    private void showVideos(Predicate<Video> p, String title) {
        showVideos(p, title, null);
    }

    private void showVideos(Predicate<Video> p, String title, Person lecturer) {
        rightContainer = new JPanel();
        rightContainer.setLayout(new BorderLayout());

        // header
        JLabel lblTitle = new JLabel(title, JLabel.CENTER);
        Font f = lblTitle.getFont();
        lblTitle.setFont(new Font(f.getName(), Font.BOLD, 30));
        rightContainer.add(lblTitle, BorderLayout.PAGE_START);

        // footer
        if (lecturer == null) {
            rightContainer.add(btnShowTop, BorderLayout.PAGE_END);
        } else {
//            JPanel footer = new JPanel();
//            footer.setLayout(new GridBagLayout());
//            rightContainer.add(footer, BorderLayout.PAGE_END);
//
//            GridBagConstraints c = new GridBagConstraints();
//            c.gridy = 0;
//            c.gridx = 0;
//            c.anchor = GridBagConstraints.LINE_START;
//            footer.add(btnShowTop, c);
//
//            JButton lecturerButton = new JButton("Show Lecturer Profile >>");
//            c.gridx = 1;
//            c.anchor = GridBagConstraints.LINE_END;
//            footer.add(lecturerButton, c);
            JPanel footer = new JPanel();
            footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));
            rightContainer.add(footer, BorderLayout.PAGE_END);

            footer.add(btnShowTop);
            footer.add(Box.createHorizontalGlue());
            JButton lecturerButton = new JButton("Show Lecturer Profile >>");
            lecturerButton.addActionListener(e -> parent.pushComponent(new LecturerVideo(parent, lecturer, account)));
            footer.add(lecturerButton);
        }

        JPanel boxContainer = new JPanel();
        boxContainer.setBackground(new Color(153, 153, 153));
        boxContainer.setLayout(new BoxLayout(boxContainer, BoxLayout.Y_AXIS));

        Stream<Video> videoStream = account.getOrg()
                .getEnterprise()
                .getNetwork()
                .getVideoCatalog()
                .getVideoArrayList()
                .stream()
                .filter(Video::canView)
                .filter(p);
        populateVideoBoxes(videoStream, boxContainer);

        JScrollPane rightScroll = new JScrollPane(boxContainer);
        rightContainer.add(rightScroll);

        splitPane.setRightComponent(rightContainer);

        revalidate();
        repaint();
    }

    private void showLecturerVideos(Person lecturer) {
        String title = String.format("%s's Videos", lecturer);
        showVideos(v -> v.getUploaderAccount().getPerson().equals(lecturer), title, lecturer);
        state = State.LecturerVideos;
        showingLecturer = lecturer;
    }

    private void showTagVideos(VideoTag tag) {
        String title = String.format("%s Videos", tag);
        showVideos(v -> v.getTagHashSet().contains(tag), title);
        state = State.TagVideos;
        showingTag = tag;
    }

    private void populateVideoBoxes(Stream<Video> videos, JPanel boxContainer) {
        videos.forEach(video -> {
            boxContainer.add(new VideoBox(parent, video, account));
            boxContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        });
    }

    private void treeNodeSelected(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        if (node.getUserObject() instanceof LecturerTree.LecturerWithNumber) {
            Person lecturer = ((LecturerTree.LecturerWithNumber) node.getUserObject()).getLecturer();
            showLecturerVideos(lecturer);
        }
    }

    private void tagSelected(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) {
            return;
        }
        TagList.TagWithNumber tn = tagList.getSelectedValue();
        if (tn != null) {
            showTagVideos(tn.getTag());
        }
    }

    @Override
    public void exposed() {
        switch (state) {
            case TopVideos:
                showTopVideos();
                break;
            case TagVideos:
                showTagVideos(showingTag);
                break;
            case LecturerVideos:
                showLecturerVideos(showingLecturer);
                break;
        }
    }
}
