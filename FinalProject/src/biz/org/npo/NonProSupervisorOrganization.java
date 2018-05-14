/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.npo;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.supervisorRole.NoneProSupervisorRole;
import java.util.ArrayList;

public class NonProSupervisorOrganization extends Organization {
    private NoneProSupervisorRole nonProSupervisorRole;

    public NonProSupervisorOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.nonProSupervisorRole = new NoneProSupervisorRole();
    }

    public NoneProSupervisorRole getNonProSupervisorRole() {
        return nonProSupervisorRole;
    }
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(nonProSupervisorRole);
        return roles;
    }

}
