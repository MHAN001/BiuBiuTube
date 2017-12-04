/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org;

import biz.enterprises.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public abstract class OrganizationCatalog<Org extends Organization> {
    protected Enterprise enterprise;
    protected ArrayList<Org> organizations;

    public OrganizationCatalog(Enterprise enterprise) {
        this.enterprise = enterprise;
        organizations = new ArrayList<>();
    }
    
    public ArrayList<Org> getOrganizations() {
        return organizations;
    }

    public abstract Org newOrganization(String name);

    public void removeOrganization(Org org) {
        this.organizations.remove(org);
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }
}
