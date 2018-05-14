/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.npo;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.producerRole.NoneProfitProducerRole;
import java.util.ArrayList;

public class NonProPSAOrganization extends Organization {
    private NoneProfitProducerRole nonProfitProducerRole;


    public NonProPSAOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.nonProfitProducerRole = new NoneProfitProducerRole();
    }

    public NoneProfitProducerRole getNonProfitProducerRole() {
        return nonProfitProducerRole;
    }
    
    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(nonProfitProducerRole);
        return roles;
    }

}
