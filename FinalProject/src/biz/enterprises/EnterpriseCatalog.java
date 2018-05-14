/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.enterprises;

import biz.nw.Network;

import java.util.ArrayList;

/**
 *
 * @author 79813
 */
public abstract class EnterpriseCatalog<Enterprise> {
    protected Network network;
    protected ArrayList<Enterprise> enterprises;

    public EnterpriseCatalog(Network network) {
        this.network = network;
        this.enterprises = new ArrayList<>();
    }

    public abstract Enterprise newEnterprise(String name);

    public void removeEnterprise(Enterprise e) {
        this.enterprises.remove(e);
    }

    public Network getNetwork() {
        return network;
    }

    public ArrayList<Enterprise> getEnterprises() {
        return enterprises;
    }
    
}
