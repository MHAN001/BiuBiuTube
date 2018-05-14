package biz.enterprises;

import biz.nw.Network;

public class NPOEnterpriseCatalog extends EnterpriseCatalog<NPOEnterprise> {
    public NPOEnterpriseCatalog(Network network) {
        super(network);
    }

    @Override
    public NPOEnterprise newEnterprise(String name) {
        NPOEnterprise e = new NPOEnterprise(name, network);
        this.enterprises.add(e);
        return e;
    }
}
