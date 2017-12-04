/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.fnc;

import biz.enterprises.AdCompanyEnterprise;

import java.util.Calendar;

/**
 * @author 79813
 */
public class AdViewsOrder {
    private Calendar createdAt;
    private int quantity;
    private String information;
    private AdCompanyEnterprise company;
    private Status status;

    public AdViewsOrder(AdCompanyEnterprise companyEnterprise, int quantity, String information) {
        this.quantity = quantity;
        this.information = information;
        this.createdAt = Calendar.getInstance();
        this.company = companyEnterprise;
        this.status = Status.Submitted;
    }

    public Status getStatus() {
        return status;
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
        company.setRemainingAdViews(company.getRemainingAdViews() + quantity);
    }

    public void reject() throws Exception {
        if (!status.equals(Status.Submitted)) {
            throw new Exception();
        }
        status = Status.Canceled;
    }


    public Calendar getCreatedAt() {
        return createdAt;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getInformation() {
        return information;
    }

    public AdCompanyEnterprise getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return createdAt.getTime().toString();
    }
}
