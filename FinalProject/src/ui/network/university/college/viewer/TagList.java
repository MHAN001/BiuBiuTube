package ui.network.university.college.viewer;

import biz.account.Account;
import biz.nw.Network;
import biz.video.VideoTag;

import javax.swing.*;
import java.util.*;

public class TagList extends JList<TagList.TagWithNumber> {
    class TagWithNumber {
        private VideoTag tag;
        private int number;

        TagWithNumber(VideoTag tag, int number) {
            this.number = number;
            this.tag = tag;
        }

        @Override
        public String toString() {
            return String.format("%s (%d)", tag, number);
        }

        public VideoTag getTag() {
            return tag;
        }

        public int getNumber() {
            return number;
        }
    }

    public TagList(Account account) {
        super();
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Network network = account.getOrg().getEnterprise().getNetwork();
        HashMap<VideoTag, Integer> map = network.getVideoTagCatalog().countCanViewVideoByTag();
        TagWithNumber[] tagArr = map.entrySet().stream().map(e -> new TagWithNumber(e.getKey(), e.getValue())).toArray(TagWithNumber[]::new);
        List<TagWithNumber> tagList =  Arrays.asList(tagArr);
        tagList.sort(Comparator.comparingInt(TagWithNumber::getNumber).reversed());
        DefaultListModel<TagWithNumber> dlm = new DefaultListModel<>();
        tagList.forEach(dlm::addElement);
        setModel(dlm);
    }
}
