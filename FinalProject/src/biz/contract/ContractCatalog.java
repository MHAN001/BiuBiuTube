/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.contract;

import biz.account.Account;
import biz.nw.Network;
import java.util.ArrayList;

/**
 *
 * @author royn
 */
public class ContractCatalog {

    private Network network;
    private ArrayList<Contract> contractArrayList;

    public ContractCatalog(Network network) {
        this.network = network;
        this.contractArrayList = new ArrayList<>();
    }

    public Contract newContract(Account account) {
        Contract contract = new Contract(account);
        contractArrayList.add(contract);
        return contract;
    }

    public ArrayList<Contract> getContractArrayList(){
        return contractArrayList;
    }
    
    public Network getNetwork(){
        return network;
    }
}
