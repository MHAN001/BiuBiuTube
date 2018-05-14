package biz.fnc;

import biz.account.Account;
import biz.enterprises.UniversityEnterprise;

import java.util.ArrayList;

public class ReloadCoinOrderCatalog {
    private ArrayList<ReloadCoinOrder> reloadOrderArrayList;
    private UniversityEnterprise universityEnterprise;

    public ReloadCoinOrderCatalog(UniversityEnterprise universityEnterprise) {
        this.reloadOrderArrayList = new ArrayList<>();
        this.universityEnterprise = universityEnterprise;
    }

    public ReloadCoinOrder newReloadCoinOrder(Account account, int amount, String payment) {
        ReloadCoinOrder o = new ReloadCoinOrder(account, amount, payment);
        this.reloadOrderArrayList.add(o);
        return o;
    }

    public UniversityEnterprise getUniversityEnterprise() {
        return universityEnterprise;
    }

    public ArrayList<ReloadCoinOrder> getReloadOrderArrayList() {
        return reloadOrderArrayList;
    }
}
