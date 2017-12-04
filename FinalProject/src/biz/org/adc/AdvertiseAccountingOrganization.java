/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.accountingRole.AdvertiseAccountingRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdvertiseAccountingOrganization extends Organization {

    private AdvertiseAccountingRole advertiseAccountingRole;

    public AdvertiseAccountingOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.advertiseAccountingRole = new AdvertiseAccountingRole();
    }

    public AdvertiseAccountingRole getAdvertiseAccountingRole() {
        return advertiseAccountingRole;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(advertiseAccountingRole);
        return roles;
    }

}
