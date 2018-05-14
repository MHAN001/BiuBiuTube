/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.salesRole.SalesManagerRole;
import biz.role.salesRole.SalesPersonRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class UniverseSalesOrganization extends Organization {
    private SalesManagerRole salesManagerRole;
    private SalesPersonRole salesPersonRole;

    public UniverseSalesOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.salesManagerRole = new SalesManagerRole();
        this.salesPersonRole = new SalesPersonRole();
    }
    
    public SalesManagerRole getSalesManagerRole() {
        return salesManagerRole;
    }

    public SalesPersonRole getSalesPersonRole() {
        return salesPersonRole;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(salesPersonRole);
        roles.add(salesManagerRole);
        return roles;
    }
    
}
