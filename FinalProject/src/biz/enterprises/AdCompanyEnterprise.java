package biz.enterprises;

import biz.contract.Contract;
import biz.fnc.AdViewsOrderCatalog;
import biz.nw.Network;
import biz.org.Organization;
import biz.org.adc.AdvertiseAccountingOrganization;
import biz.org.adc.AdvertiseAdminOrganization;
import biz.org.adc.AdvertiseProduceOrganizationCatalog;
import biz.org.adc.AdvertiseSupervisorOrganization;

import java.util.ArrayList;

public class AdCompanyEnterprise extends Enterprise {

    private AdvertiseAccountingOrganization aAccount;
    private AdvertiseAdminOrganization aAdmin;
    private AdvertiseProduceOrganizationCatalog aPCatalog;
    private AdvertiseSupervisorOrganization aSupervisor;
    private AdViewsOrderCatalog adViewsOrderCatalog;
    private ArrayList<Organization> organizations;
    private double k0;
    private int enterpriseValue;
    private int remainingAdViews;


    public int getEnterpriseValue() {
        return enterpriseValue;
    }

    public void setEnterpriseValue(int enterpriseValue) {
        this.enterpriseValue = enterpriseValue;
    }

    public AdCompanyEnterprise(String name, Network network) {
        super(name, network);
        k0 = 0.1;
        this.aPCatalog = new AdvertiseProduceOrganizationCatalog(this);

        this.aAccount = new AdvertiseAccountingOrganization(name + "AdvertiseAccountingOrganization", this);
        this.aAdmin = new AdvertiseAdminOrganization(name + "AdvertiseAdminOrganization", this);
        this.aSupervisor = new AdvertiseSupervisorOrganization(name + "AdvertiseSupervisorOrganization", this);
        this.adViewsOrderCatalog = new AdViewsOrderCatalog(this);

        this.remainingAdViews = 0;
    }

    public ArrayList<Organization> getOrganizationArrayList() {
        ArrayList<Organization> organizationArrayList = new ArrayList<>();
        organizationArrayList.addAll(aPCatalog.getOrganizations());
        organizationArrayList.add(aAdmin);
        organizationArrayList.add(aAccount);
        organizationArrayList.add(aSupervisor);
        return organizationArrayList;
    }

    public AdvertiseAccountingOrganization getaAccount() {
        return aAccount;
    }

    public AdvertiseAdminOrganization getaAdmin() {
        return aAdmin;
    }

    public AdvertiseProduceOrganizationCatalog getaPCatalog() {
        return aPCatalog;
    }

    public AdvertiseSupervisorOrganization getaSupervisor() {
        return aSupervisor;
    }

    public ArrayList<Organization> getOrganizations() {
        return organizations;
    }

    public double getK0() {
        return k0;
    }

    public void setK0(double k0) {
        this.k0 = k0;
    }

    public AdViewsOrderCatalog getAdViewsOrderCatalog() {
        return adViewsOrderCatalog;
    }
    
    public int getRemainingAdViews() {
        return remainingAdViews;
    }

    public void setRemainingAdViews(int remainingAdViews) {
        this.remainingAdViews = remainingAdViews;
    }
    
    public double getAdViewPrice(int quantity) {
        if (quantity < 50) {
            return k0 * quantity;
        }

        if (quantity < 250) {
            return k0 * 50 + k0 * (quantity - 50) * 0.8;
        }

        if (quantity < 1250) {
            return k0 * 50 + k0 * 200 * 0.8 + k0 * (quantity - 250) * 0.6;
        }

        return k0 * 50 + k0 * 200 * 0.8 + k0 * 1000 * 0.6 + k0 * (quantity - 1250) * 0.4;
    }
}
