/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz;

import biz.account.Account;
import biz.account.AccountCatalog;
import biz.nw.Network;
import biz.person.Person;
import biz.person.PersonCatalog;
import biz.role.adminRole.SystemAdminRole;
import biz.role.customerServiceRole.CensorRole;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 79813
 */
public class EcoSystem {

    private static EcoSystem system;
    private PersonCatalog systemPersonCatalog;
    private AccountCatalog systemAccountCatalog;

    private SystemAdminRole systemAdminRole;
    private CensorRole systemCensorRole;

    private ArrayList<Network> networkArrayList;
    private ArrayList<Account> allAccountArrayList;

    private EcoSystem() {
        systemPersonCatalog = new PersonCatalog(null);
        systemAccountCatalog = new AccountCatalog(null);
        networkArrayList = new ArrayList<>();
        allAccountArrayList = new ArrayList<>();

        systemAdminRole = new SystemAdminRole();
        systemCensorRole = new CensorRole();
    }

    public static EcoSystem getInstance() {
        if (system == null) {
            system = new EcoSystem();
        }
        return system;
    }

    public void addAccount(Account account) throws Exception {
        if (this.allAccountArrayList
                .stream()
                .anyMatch(a -> a.getUsername().equals(account.getUsername()))) {
            throw new Exception("Duplicate Username.");
        }
        this.allAccountArrayList.add(account);
    }

    public void removeAccount(Account account) {
        this.allAccountArrayList.remove(account);
    }

    public Network newNetwork(String name) {
        Network network = new Network(name);
        networkArrayList.add(network);
        return network;
    }

    public PersonCatalog getSystemPersonCatalog() {
        return systemPersonCatalog;
    }

    public AccountCatalog getSystemAccountCatalog() {
        return systemAccountCatalog;
    }

    public ArrayList<Network> getNetworkArrayList() {
        return networkArrayList;
    }

    public Account login(String username, String password) throws Exception {
        Account account = allAccountArrayList.stream().filter(acc -> acc.getUsername().equals(username)).findFirst().orElse(null);
        if (account == null) {
            throw new Exception("Account Not Found.");
        }
        if (!account.checkPassword(password)) {
            throw new Exception("Password Mismatch.");
        }
        if (!account.isActive()) {
            throw new Exception("Account InActive.");
        }
        if (account.getOrg()!= null && !account.getOrg().getEnterprise().isActive()) {
            throw new Exception("Account's Enterprise InActive.");
        }
        return account;
    }

    public SystemAdminRole getSystemAdminRole() {
        return systemAdminRole;
    }

    public CensorRole getSystemCensorRole() {
        return systemCensorRole;
    }

    public ArrayList<Account> getAllAccountArrayList() {
        return allAccountArrayList;
    }
    
    public boolean isUsernameExist(String username) {
        return this.allAccountArrayList.stream().anyMatch(a -> a.getUsername().equals(username));
    }
    public HashMap<Person, Integer> countSystemAccount() {
        HashMap<Person, Integer> map = new HashMap<>();
        for (Person p: systemPersonCatalog.getPersonList()) {
            map.put(p, 0);
        }
        for (Account account: systemAccountCatalog.getAccountArrayList()) {
            Person p = account.getPerson();
            int oldNumer = map.get(p);
            map.put(p, oldNumer + 1);
        }
        return map;
    }
    
}
