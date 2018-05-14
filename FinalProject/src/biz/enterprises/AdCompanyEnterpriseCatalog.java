package biz.enterprises;

import biz.nw.Network;

public class AdCompanyEnterpriseCatalog extends EnterpriseCatalog<AdCompanyEnterprise> {

    public AdCompanyEnterpriseCatalog(Network network) {
        super(network);
    }

    @Override
    public AdCompanyEnterprise newEnterprise(String name) {
        AdCompanyEnterprise e = new AdCompanyEnterprise(name, network);
        this.enterprises.add(e);
        return e;
    }

}
