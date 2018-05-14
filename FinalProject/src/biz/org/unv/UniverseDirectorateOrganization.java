/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.adminRole.UniversityDirectorateRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class UniverseDirectorateOrganization extends Organization {
    private UniversityDirectorateRole directorateRole;

    public UniversityDirectorateRole getDirectorateRole() {
        return directorateRole;
    }

    public UniverseDirectorateOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(directorateRole);
        return roles;
    }
    
}
