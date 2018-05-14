package biz.video;

import biz.account.Account;
import biz.nw.Network;

import java.util.ArrayList;

public class VideoCatalog {
    private ArrayList<Video> videoArrayList;
    private Network network;

    public VideoCatalog(Network network) {
        this.network = network;
        this.videoArrayList = new ArrayList<>();
    }

    public Video newVideo(Account account) {
        Video video = new Video(account);
        this.videoArrayList.add(video);
        return video;
    }

    public ArrayList<Video> getVideoArrayList() {
        return videoArrayList;
    }

    public Network getNetwork() {
        return network;
    }
}
