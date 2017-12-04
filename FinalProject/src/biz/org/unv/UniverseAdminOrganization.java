/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.adminRole.UniversityAdminRole;
import java.util.ArrayList;

public class UniverseAdminOrganization extends Organization {
    private UniversityAdminRole admin;

    public UniversityAdminRole getAdmin() {
        return admin;
    }

    public UniverseAdminOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.admin = new UniversityAdminRole();
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(admin);
        return roles;
    }
    
}
