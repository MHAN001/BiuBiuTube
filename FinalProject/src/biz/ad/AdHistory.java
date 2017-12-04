/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ad;

import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import java.util.Calendar;

/**
 *
 * @author 79813
 */
public class AdHistory {
    private Account account;
    private Ad advertisement;
    private Calendar calendar;
    private static int count;
    private int viewedQuantity;
    

    public AdHistory(Ad ad,Account account) {
        this.advertisement = ad;
        this.account = account;
        count++;
        this.viewedQuantity = count;
//        this.quantityNow = 
        
    }

//    public AdCompanyEnterprise getCompany() {
//        return company;
//    }

    public Ad getAdvertisement() {
        return advertisement;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public int getViewedQuantity() {
        return viewedQuantity;
    }
    
    @Override
    public String toString() {
        return calendar.toString() + " - " + account.toString();
    }
}
