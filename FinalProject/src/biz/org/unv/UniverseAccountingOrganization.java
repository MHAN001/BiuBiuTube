/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.accountingRole.UniversityAccountingRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class UniverseAccountingOrganization extends Organization {
    private UniversityAccountingRole universityAccountingRole;

    public UniverseAccountingOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.universityAccountingRole = new UniversityAccountingRole();
    }

    public UniversityAccountingRole getUniversityAccountingRole() {
        return universityAccountingRole;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles =  new ArrayList<>();
        roles.add(universityAccountingRole);
        return roles;
    }

}
