/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.ad;

import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdHistoryCatalog {
    private Ad ad;
    private ArrayList<AdHistory> adHistorys;
    
    public AdHistoryCatalog(Ad ad){
        this.ad = ad;
        this.adHistorys = new ArrayList<>();
    }
    
    public AdHistory newAdHistory(Account account){
        AdHistory hist = new AdHistory(this.ad,account);
        this.adHistorys.add(hist);
        return hist;
    }

    public Ad getAd() {
        return ad;
    }

    public ArrayList<AdHistory> getAdHistorys() {
        return adHistorys;
    }
    
}
