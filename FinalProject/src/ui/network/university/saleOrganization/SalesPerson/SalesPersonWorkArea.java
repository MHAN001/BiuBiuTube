/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.saleOrganization.SalesPerson;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author royn
 */
public class SalesPersonWorkArea extends GeneralWorkArea{

    public SalesPersonWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton btnManageContract = new JButton("Manage Contracts");
        btnManageContract.addActionListener((e -> parent.pushComponent(new ManageContracts(parent, account))));
        
        
        JButton btnAddContract = new JButton("Add Contracts");
        btnAddContract.addActionListener((e -> parent.pushComponent(new EditOrAddContract(account))));
        
        buttons.add(btnManageContract);
        buttons.add(btnAddContract);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("Sales Panel in %s", account.getOrg().getEnterprise().getNetwork());
    }
    
}
