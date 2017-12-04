/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.adminOrganization;

import ui.network.commonadm.ManageOrganization.ManageOrganization;
import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;
import ui.network.commonadm.ManageAccount.ManageAccounts;
import ui.network.commonadm.ManagePerson.ManagePerson;

/**
 *
 * @author royn
 */
public class UniversityAdminWorkArea extends GeneralWorkArea{

    public UniversityAdminWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton btnManageAccount = new JButton("Manage Account");
        btnManageAccount.addActionListener(e -> parent.pushComponent(new ManageAccounts(parent, account)));

        JButton btnManagePerson = new JButton("Manage Person");
        btnManagePerson.addActionListener(e -> parent.pushComponent(new ManagePerson(parent, account)));

        JButton btnManageCollege = new JButton("Manage College");
        btnManageCollege.addActionListener(e -> parent.pushComponent(new ManageOrganization(parent, account)));

        buttons.add(btnManageAccount);
        buttons.add(btnManagePerson);
        buttons.add(btnManageCollege);

        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("Admin Person and Account of %s", account.getOrg().getEnterprise());
    }
    
}
