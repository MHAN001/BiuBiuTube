package biz.enterprises;

import biz.nw.Network;
import biz.org.Organization;
import biz.org.eco.ECOAdminOrganization;
import biz.org.eco.ECOSupervisorOrganization;
import biz.org.eco.ECOVideoProducerOrganizationCatalog;
import java.util.ArrayList;

public class ECOEnterprise extends Enterprise {

    private ECOVideoProducerOrganizationCatalog ecovpoc;
    private ECOSupervisorOrganization ecoso;
    private ECOAdminOrganization ecoao;
    public ECOEnterprise(String name, Network network) {
        super(name, network);
        this.ecovpoc = new ECOVideoProducerOrganizationCatalog(this);
        //sole organizations
        this.ecoso = new ECOSupervisorOrganization(name + "ECOSupervisorOrganization", this);
        this.ecoao = new ECOAdminOrganization(name + "ECOAdminOrganization", this);
    }

    public ECOVideoProducerOrganizationCatalog getEcovpoc() {
        return ecovpoc;
    }

    public ECOSupervisorOrganization getEcoso() {
        return ecoso;
    }

    public ECOAdminOrganization getEcoao() {
        return ecoao;
    }

    @Override
    public ArrayList<Organization> getOrganizationArrayList() {
       ArrayList<Organization> organizationArrayList = new ArrayList<>();
        organizationArrayList.addAll(ecovpoc.getOrganizations());
        organizationArrayList.add(ecoso);
        organizationArrayList.add(ecoao);
        return organizationArrayList;
    }
    
    
    
}
