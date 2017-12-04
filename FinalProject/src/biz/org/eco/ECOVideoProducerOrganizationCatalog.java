/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.org.eco;

import biz.enterprises.ECOEnterprise;
import biz.enterprises.Enterprise;
import biz.org.OrganizationCatalog;

/**
 *
 * @author 79813
 */
public class ECOVideoProducerOrganizationCatalog extends OrganizationCatalog<ECOVideoProducerOrganization>{

    public ECOVideoProducerOrganizationCatalog(Enterprise enterprise) {
        super(enterprise);
    }

    @Override
    public ECOVideoProducerOrganization newOrganization(String name) {
        ECOVideoProducerOrganization ecovpo = new ECOVideoProducerOrganization(name , enterprise);
        organizations.add(ecovpo);
        return ecovpo;
    }
    
}
