package biz.account;

import java.util.Calendar;

public class WalletHistory {
    private Calendar calendar;
    private int amount;

    WalletHistory(int amount) {
        this.calendar = Calendar.getInstance();
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public Calendar getCalendar() {
        return calendar;
    }
}
