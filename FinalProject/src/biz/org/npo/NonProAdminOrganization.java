/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.npo;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.adminRole.NoneProfitAdminRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class NonProAdminOrganization extends Organization {
    private NoneProfitAdminRole admin;

    public NoneProfitAdminRole getAdmin() {
        return admin;
    }

    public NonProAdminOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.admin = new NoneProfitAdminRole();
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(admin);
        return roles;
    }
    
}
