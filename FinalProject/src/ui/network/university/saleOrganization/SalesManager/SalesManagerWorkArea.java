/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.saleOrganization.SalesManager;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author royn
 */
public class SalesManagerWorkArea extends GeneralWorkArea{

    public SalesManagerWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton btnManageContract = new JButton("Manage Contracts");
        btnManageContract.addActionListener((e -> parent.pushComponent(new CensorContracts(parent, account))));
        buttons.add(btnManageContract);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("Manage contract of %s", account.getOrg().getEnterprise().getNetwork());
    }
    
}
