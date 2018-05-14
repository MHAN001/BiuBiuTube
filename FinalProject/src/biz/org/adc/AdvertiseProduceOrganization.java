/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.Organization;
import biz.role.Role;
import biz.role.producerRole.AdvertisementProducerRole;
import java.util.ArrayList;

public class AdvertiseProduceOrganization extends Organization {

    private AdvertisementProducerRole adProducerRole;

    public AdvertisementProducerRole getAdProducerRole() {
        return adProducerRole;
    }

    public AdvertiseProduceOrganization(String name, Enterprise enterprise) {
        super(name, enterprise);
        this.adProducerRole = new AdvertisementProducerRole();
    }

    @Override
    public ArrayList<Role> getSupportedRoles() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(adProducerRole);
        return roles;
    }

}
