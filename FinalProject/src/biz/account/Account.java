/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.account;

import biz.fnc.PrimeMembership;
import biz.org.Organization;
import biz.person.Person;
import biz.role.Role;
import biz.role.consumerRole.ViewerRole;

/**
 * @author 79813
 */
public class Account {

    private Organization org;
    private String username;
    private String passwordHash;
    private Person person;
    private boolean isActive;
    private Role role;
    private Wallet wallet;
    private PrimeMembership primeMembership;

    public Account(Organization organization, String username, String password, Role role, Person person) {
        this.person = person;
        this.username = username;
        setPassword(password);
        this.role = role;
        this.org = organization;
        this.isActive = true;

        if (role instanceof ViewerRole) {
            this.wallet = new Wallet(this);
            this.primeMembership = new PrimeMembership(this);
        }
    }

    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean checkPassword(String password) {
        return this.passwordHash.equals(HashHelper.generateHash(password));
    }

    public void setPassword(String password) {
        this.passwordHash = HashHelper.generateHash(password);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return username;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public PrimeMembership getPrimeMembership() {
        return primeMembership;
    }
}
