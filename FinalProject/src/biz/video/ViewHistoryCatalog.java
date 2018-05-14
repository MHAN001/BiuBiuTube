package biz.video;

import biz.account.Account;

import java.util.ArrayList;

public class ViewHistoryCatalog {
    private Video video;
    private ArrayList<ViewHistory> viewHistoryArrayList;

    ViewHistoryCatalog(Video video) {
        this.video = video;
        this.viewHistoryArrayList = new ArrayList<>();
    }

    public ViewHistory newViewHistory(Account account) {
        ViewHistory vh = new ViewHistory(this.video, account);
        this.viewHistoryArrayList.add(vh);
        return vh;
    }

    public Video getVideo() {
        return video;
    }

    public ArrayList<ViewHistory> getViewHistoryArrayList() {
        return viewHistoryArrayList;
    }
}
