package biz.video;

import biz.account.Account;

import java.util.Calendar;

public class Report {
    private Video video;
    private Account account;
    private String message;
    private boolean isDeleted;
    private Calendar createdAt;

    public Report(Video video, Account account, String message) {
        this.video = video;
        this.account = account;
        this.message = message;
        this.isDeleted = false;
        this.createdAt = Calendar.getInstance();
    }

    public void delete() {
        this.isDeleted = true;
    }

    public Video getVideo() {
        return video;
    }

    public Account getAccount() {
        return account;
    }

    public String getMessage() {
        return message;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return createdAt.getTime().toString();
    }
}
