/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.eco;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.adminRole.ECOAdminRole;
import java.util.ArrayList;

/**
 *
 * @author royn
 */
public class ECOAdminOrganization extends Organization {
    private ECOAdminRole admin;

    public ECOAdminOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.admin = new ECOAdminRole();
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(admin);
        return roles;
    }
    
}
