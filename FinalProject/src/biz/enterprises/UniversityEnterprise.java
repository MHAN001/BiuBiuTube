package biz.enterprises;

import biz.fnc.ReloadCoinOrderCatalog;
import biz.nw.Network;
import biz.org.Organization;
import biz.org.unv.*;

import java.util.ArrayList;

public class UniversityEnterprise extends Enterprise {

    private UniverseCollegeOrganizationCatalog collegeCatalog;
    private UniverseSupervisorOrganization supervisorOrganization;
    private UniverseDirectorateOrganization directorateOrganization;
    private UniverseSalesOrganization salesDepartmentOrganization;
    private UniverseAdminOrganization adminOrganization;
    private UniverseAccountingOrganization accountingOrganization;
    private ReloadCoinOrderCatalog reloadCoinOrderCatalog;

    public UniversityEnterprise(String name, Network network) {
        super(name, network);
        this.collegeCatalog = new UniverseCollegeOrganizationCatalog(this);
        //sole organizations
        this.supervisorOrganization = new UniverseSupervisorOrganization(name + " Supervisor Department", this);
        this.directorateOrganization = new UniverseDirectorateOrganization(name + " Board", this);
        this.salesDepartmentOrganization = new UniverseSalesOrganization(name + " Sales", this);
        this.adminOrganization = new UniverseAdminOrganization(name + " Admin Organization", this);
        this.accountingOrganization = new UniverseAccountingOrganization(name + " Accounting Organization", this);

        this.reloadCoinOrderCatalog = new ReloadCoinOrderCatalog(this);
    }

    @Override
    public ArrayList<Organization> getOrganizationArrayList() {
        ArrayList<Organization> organizationArrayList = new ArrayList<>();
        organizationArrayList.addAll(collegeCatalog.getOrganizations());
        organizationArrayList.add(supervisorOrganization);
        organizationArrayList.add(directorateOrganization);
        organizationArrayList.add(salesDepartmentOrganization);
        organizationArrayList.add(adminOrganization);
        organizationArrayList.add(accountingOrganization);
        return organizationArrayList;
    }

    public UniverseSupervisorOrganization getSupervisorOrganization() {
        return supervisorOrganization;
    }

    public UniverseAccountingOrganization getAccountingOrganization() {
        return accountingOrganization;
    }

    public UniverseAdminOrganization getAdminOrganization() {
        return adminOrganization;
    }

    public UniverseSalesOrganization getSalesDepartmentOrganization() {
        return salesDepartmentOrganization;
    }

    public UniverseDirectorateOrganization getDirectorateOrganization() {
        return directorateOrganization;
    }

    public UniverseCollegeOrganizationCatalog getCollegeCatalog() {
        return collegeCatalog;
    }

    public ReloadCoinOrderCatalog getReloadCoinOrderCatalog() {
        return reloadCoinOrderCatalog;
    }
}
