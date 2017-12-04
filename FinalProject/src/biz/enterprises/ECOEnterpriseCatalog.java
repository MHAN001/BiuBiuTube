package biz.enterprises;

import biz.nw.Network;

public class ECOEnterpriseCatalog extends EnterpriseCatalog<ECOEnterprise> {

    public ECOEnterpriseCatalog(Network network) {
        super(network);
    }

    @Override
    public ECOEnterprise newEnterprise(String name) {
        ECOEnterprise e = new ECOEnterprise(name, network);
        this.enterprises.add(e);
        return e;
    }
}
