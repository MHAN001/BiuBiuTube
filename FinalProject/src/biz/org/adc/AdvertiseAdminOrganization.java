/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.adminRole.AdvertiseAdminRole;
import biz.role.producerRole.AdvertisementProducerRole;
import biz.role.supervisorRole.ADCompanySupervisorRole;
import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public class AdvertiseAdminOrganization extends Organization {

    private AdvertiseAdminRole admin;

    public AdvertiseAdminOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.admin = new AdvertiseAdminRole();
    }

    public AdvertiseAdminRole getAdAdminRole() {
        return admin;
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(admin);
        return roles;
    }

}
