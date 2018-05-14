package biz.video;

import biz.account.Account;

import java.util.Calendar;

public class Comment {
    private String content;
    private Account account;
    private Calendar calendar;

    Comment(Account account, String content) {
        this.account = account;
        this.content = content;
        this.calendar = Calendar.getInstance();
    }

    public String getContent() {
        return content;
    }

    public Account getAccount() {
        return account;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    @Override
    public String toString() {
        return content;
    }
}
