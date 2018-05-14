/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.account;

import biz.EcoSystem;
import biz.org.Organization;
import biz.person.Person;
import biz.role.Role;

import java.util.ArrayList;

/**
 * @author 79813
 */
public class AccountCatalog {
    private Organization org;
    private ArrayList<Account> accountArrayList;

    public AccountCatalog(Organization org) {
        this.org = org;
        this.accountArrayList = new ArrayList<>();
    }

    public Organization getOrg() {
        return org;
    }

    public Account newAccount(String username, String password, Role role, Person person) throws Exception {
        Account acc = new Account(org, username, password, role, person);
        EcoSystem.getInstance().addAccount(acc);
        this.accountArrayList.add(acc);
        return acc;
    }

    public void removeAccount(Account account) {
        this.accountArrayList.remove(account);
        EcoSystem.getInstance().removeAccount(account);
    }

    public ArrayList<Account> getAccountArrayList() {
        return accountArrayList;
    }
}
