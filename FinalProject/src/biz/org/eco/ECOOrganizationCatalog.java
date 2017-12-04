package biz.org.eco;

import biz.enterprises.Enterprise;
import biz.org.OrganizationCatalog;

public class ECOOrganizationCatalog extends OrganizationCatalog<ECOVideoProducerOrganization> {

    public ECOOrganizationCatalog(Enterprise enterprise) {
        super(enterprise);
    }

    @Override
    public ECOVideoProducerOrganization newOrganization(String name) {
        ECOVideoProducerOrganization ecoco = new ECOVideoProducerOrganization(name, enterprise);
        this.organizations.add(ecoco);
        return ecoco;
    }
}
