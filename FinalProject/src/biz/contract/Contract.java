/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.contract;

import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;

import java.util.Calendar;

/**
 *
 * @author royn
 */
public class Contract {
    private Account account;
    private AdCompanyEnterprise adCompanyEnterprise;
    private Calendar signedAt;
    private Calendar approveBySalesManagerAt;
    private Calendar approveByDireactorAt;
    private ContractStatus contractStatus;
    
     public enum ContractStatus{
        Created("Produced", "Contract is produced, waiting sales manager to approve."),
        SMApproved("Sales Manager Approved", "Contract is approved by sales manager, waiting university direactor to approve."),
        NSApproved("Network Supervisor Approved", "Contract is approved by university direactor, ready to active."),
        Banned("Contract is Banned", "Contract is banned due to some reasons.");

        private String name;
        private String description;

        ContractStatus(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }
    
    public Contract(Account account){
        this.account = account;
        this.signedAt = Calendar.getInstance();
        this.contractStatus = ContractStatus.Created;
    }

    public ContractStatus getContractStatus(){
        return contractStatus;
    }

    public void setContractStatus(ContractStatus contractStatus) {
        this.contractStatus = contractStatus;
    }
    
    public Account getAccount() {
        return account;
    }

    public AdCompanyEnterprise getAdCompanyEnterprise() {
        return adCompanyEnterprise;
    }

    public void setAdCompanyEnterprise(AdCompanyEnterprise adCompanyEnterprise) {
        this.adCompanyEnterprise = adCompanyEnterprise;
    }

    public Calendar getApproveBySalesManagerAt() {
        return approveBySalesManagerAt;
    }

    public void setApproveBySalesManagerAt(Calendar approveBySalesManagerAt) {
        this.approveBySalesManagerAt = approveBySalesManagerAt;
    }

    public Calendar getApproveByDireactorAt() {
        return approveByDireactorAt;
    }

    public void setApproveByDireactorAt(Calendar approveByDireactorAt) {
        this.approveByDireactorAt = approveByDireactorAt;
    }

    public Calendar getSignedAt() {
        return signedAt;
    }

    public void setSignedAt(Calendar signedAt) {
        this.signedAt = signedAt;
    } 
    
    @Override
    public String toString() {
        return adCompanyEnterprise.getName();
    }
}
