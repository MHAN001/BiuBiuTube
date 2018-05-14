package biz.enterprises;

import biz.nw.Network;
import biz.org.Organization;
import biz.org.npo.NPOOrganizationCatalog;
import biz.org.npo.NonProAdminOrganization;
import biz.org.npo.NonProSupervisorOrganization;
import java.util.ArrayList;

public class NPOEnterprise extends Enterprise {

    private NonProAdminOrganization npoa;
    private NPOOrganizationCatalog npooc;
    private NonProSupervisorOrganization nposo;
    public NPOEnterprise(String name, Network network) {
        super(name, network);
        this.npooc = new NPOOrganizationCatalog(this);
        
        this.nposo = new NonProSupervisorOrganization(name + "NonProSupervisorOrganization", this);
        this.npoa = new NonProAdminOrganization(name + "NonProAdminOrganization", this);
    }
    
    @Override
    public ArrayList<Organization> getOrganizationArrayList() {
        ArrayList<Organization> organizationArrayList = new ArrayList<>();
        organizationArrayList.addAll(npooc.getOrganizations());
        organizationArrayList.add(npoa);
        organizationArrayList.add(nposo);
        return organizationArrayList;
    }

    public NonProAdminOrganization getNpoa() {
        return npoa;
    }

    public NPOOrganizationCatalog getNpooc() {
        return npooc;
    }

    public NonProSupervisorOrganization getNposo() {
        return nposo;
    }

    
}
