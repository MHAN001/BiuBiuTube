/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.nonprofitOrganizationEnterprise.adminDepartment;

import ui.network.extraCurricularOrganizationEnterprise.adminOrganization.*;
import ui.network.advertisementEnterprise.adminOrganization.*;
import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;
import ui.network.commonadm.ManageAccount.ManageAccounts;
import ui.network.commonadm.ManageOrganization.ManageOrganization;
import ui.network.commonadm.ManagePerson.ManagePerson;

/**
 *
 * @author royn
 */
public class NPOAdminWorkArea extends GeneralWorkArea{
    public NPOAdminWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton btnManageOrganization = new JButton("Manage Organization");
        btnManageOrganization.addActionListener(e -> parent.pushComponent(new ManageOrganization(parent, account)));
        
        JButton btnManageAccount = new JButton("Manage Account");
        btnManageAccount.addActionListener(e -> parent.pushComponent(new ManageAccounts(parent, account)));
        
        JButton btnManagPerson = new JButton("Manage Person");
        btnManagPerson.addActionListener(e -> parent.pushComponent(new ManagePerson(parent, account)));
        
        buttons.add(btnManageOrganization);
        buttons.add(btnManageAccount);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return "Welcome, NPAdvertisementAdmin";
    }
    
}