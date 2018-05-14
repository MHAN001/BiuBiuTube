/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.supervisorRole.UniversitySupervisorRole;

import java.util.ArrayList;

public class UniverseSupervisorOrganization extends Organization {

    private UniversitySupervisorRole universitySupervisorRole;

    public UniverseSupervisorOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        universitySupervisorRole = new UniversitySupervisorRole();
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(universitySupervisorRole);
        return roles;
    }

    public UniversitySupervisorRole getUniversitySupervisorRole() {
        return universitySupervisorRole;
    }
}
