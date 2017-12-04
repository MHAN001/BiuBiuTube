/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.eco;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.supervisorRole.ECOUniversitySupervisorRole;
import java.util.ArrayList;

public class ECOSupervisorOrganization extends Organization {
    private ECOUniversitySupervisorRole supervisorRole;

    public ECOUniversitySupervisorRole getSupervisorRole() {
        return supervisorRole;
    }

    public ECOSupervisorOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.supervisorRole = new ECOUniversitySupervisorRole();
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(supervisorRole);
        return roles;
    }
    
}
