/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.fnc;

import biz.enterprises.AdCompanyEnterprise;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdViewsOrderCatalog {
    private ArrayList<AdViewsOrder> adViewsOrders;
    private AdCompanyEnterprise company;  


    public AdViewsOrderCatalog(AdCompanyEnterprise company) {
        this.company = company;
        this.adViewsOrders = new ArrayList<>();
    }

    public AdViewsOrder newAdViewsOrder(int quantity,String information){
        AdViewsOrder order = new AdViewsOrder(company, quantity, information);
        this.adViewsOrders.add(order);
        return order;
    }
    
    public AdCompanyEnterprise getCompany() {
        return company;
    }
    
    public ArrayList<AdViewsOrder> getAdViewsOrders() {
        return adViewsOrders;
    }
  
    
}
