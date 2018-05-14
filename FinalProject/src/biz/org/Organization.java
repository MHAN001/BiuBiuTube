/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org;

import biz.account.AccountCatalog;
import biz.enterprises.Enterprise;
import biz.person.PersonCatalog;
import biz.role.Role;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public abstract class Organization {
    private String name;
    private Enterprise enterprise;
    private PersonCatalog personCatalog;
    private AccountCatalog accountCatalog;
    
    public Organization(String name, Enterprise enterprise){
        this.name = name;
        this.enterprise = enterprise;
        personCatalog = new PersonCatalog(this);
        accountCatalog = new AccountCatalog(this);
    }

    public abstract ArrayList<Role> getSupportedRoles();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonCatalog getPersonCatalog() {
        return personCatalog;
    }

    public AccountCatalog getAccountCatalog() {
        return accountCatalog;
    }
    
    @Override
    public String toString(){
        return name;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }
}
