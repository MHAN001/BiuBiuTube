package biz.video;

import biz.account.Account;

import java.util.Calendar;

public class Vote {
    private Account account;
    private Video video;
    private Calendar calendar;

    Vote(Video video, Account account) {
        this.account = account;
        this.video = video;
        this.calendar = Calendar.getInstance();
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Video getVideo() {
        return video;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return calendar.toString() + " - " + account.toString();
    }
}
