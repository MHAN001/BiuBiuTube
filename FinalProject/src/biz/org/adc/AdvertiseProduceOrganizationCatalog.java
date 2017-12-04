package biz.org.adc;

import biz.enterprises.Enterprise;
import biz.org.OrganizationCatalog;

public class AdvertiseProduceOrganizationCatalog extends OrganizationCatalog<AdvertiseProduceOrganization> {

    public AdvertiseProduceOrganizationCatalog(Enterprise enterprise) {
        super(enterprise);
    }

    @Override
    public AdvertiseProduceOrganization newOrganization(String name) {
        AdvertiseProduceOrganization apo = new AdvertiseProduceOrganization(name, enterprise);
        this.organizations.add(apo);
        return apo;
    }
}
