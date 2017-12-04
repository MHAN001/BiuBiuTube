package biz.org.npo;

import biz.enterprises.Enterprise;
import biz.org.OrganizationCatalog;

public class NPOOrganizationCatalog extends OrganizationCatalog<NonProPSAOrganization> {
    public NPOOrganizationCatalog(Enterprise enterprise) {
        super(enterprise);
    }

    @Override
    public NonProPSAOrganization newOrganization(String name) {
        NonProPSAOrganization org = new NonProPSAOrganization(name, enterprise);
        this.organizations.add(org);
        return org;
    }
}
