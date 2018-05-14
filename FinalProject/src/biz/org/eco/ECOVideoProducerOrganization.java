/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.eco;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.producerRole.ECOLecturerRole;
import java.util.ArrayList;

public class ECOVideoProducerOrganization extends Organization {

    private ECOLecturerRole ecoLecturerRole;

    public ECOVideoProducerOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.ecoLecturerRole = new ECOLecturerRole();
    }

    public ECOLecturerRole getEcoLecturerRole() {
        return ecoLecturerRole;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(ecoLecturerRole);
        return roles;
    }

}
