package biz.video;

import biz.account.Account;

import java.util.Calendar;

public class ViewHistory {
    private Account account;
    private Video video;
    private Calendar calendar;

    ViewHistory(Video video, Account account) {
        this.video = video;
        this.account = account;
        this.calendar = Calendar.getInstance();
    }

    public Account getAccount() {
        return account;
    }

    public Video getVideo() {
        return video;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public String toString() {
        return calendar.toString() + " - " + account.toString();
    }
}
