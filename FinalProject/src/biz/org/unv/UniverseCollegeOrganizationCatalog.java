package biz.org.unv;

import biz.enterprises.Enterprise;
import biz.org.OrganizationCatalog;

public class UniverseCollegeOrganizationCatalog extends OrganizationCatalog<UniverseCollegeOrganization> {
    public UniverseCollegeOrganizationCatalog(Enterprise enterprise) {
        super(enterprise);
    }

    @Override
    public UniverseCollegeOrganization newOrganization(String name) {
        UniverseCollegeOrganization college = new UniverseCollegeOrganization(name, enterprise);
        this.organizations.add(college);
        return college;
    }

}
