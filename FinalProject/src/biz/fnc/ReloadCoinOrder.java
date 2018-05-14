package biz.fnc;

import biz.account.Account;

import java.util.Calendar;

public class ReloadCoinOrder {
    private double price;
    private Calendar createdAt;
    private Calendar updatedAt;
    private Account viewer;
    private Status status;
    private int amount;
    private String payment;

    public Status getStatus() {
        return status;
    }

    ReloadCoinOrder(Account viewer, int amount, String payment) {
        this.viewer = viewer;
        this.createdAt = Calendar.getInstance();
        this.updatedAt = Calendar.getInstance();
        this.amount = amount;
        this.payment = payment;
        this.price = viewer.getOrg().getEnterprise().getNetwork().getCoinPrice(amount);
        this.status = Status.Submitted;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public Account getViewer() {
        return viewer;
    }

    public int getAmount() {
        return amount;
    }

    public Calendar getUpdatedAt() {
        return updatedAt;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public double getPrice() {
        return price;
    }

    public enum Status {
        Submitted("Submitted", "You've submitted the reload request and should have paid the bill."),
        Approved("Approved", "Your order has been approved and the coin has been added."),
        Canceled("Canceled", "The order is canceled due to some reason.");

        private String value;
        private String comment;

        Status(String value, String comment) {
            this.value = value;
            this.comment = comment;
        }

        @Override
        public String toString() {
            return value;
        }

        public String getComment() {
            return comment;
        }

        public String getValue() {
            return value;
        }
    }

    public void approve() throws Exception {
        if (!status.equals(Status.Submitted)) {
            throw new Exception("");
        }
        status = Status.Approved;
        updatedAt = Calendar.getInstance();
        viewer.getWallet().modifyCoin(amount);
    }

    public void cancel() throws Exception {
        if (!status.equals(Status.Submitted)) {
            throw new Exception();
        }
        status = Status.Canceled;
        updatedAt = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return createdAt.getTime().toString();
    }
}
