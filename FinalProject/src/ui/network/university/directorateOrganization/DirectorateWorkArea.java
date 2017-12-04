/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.directorateOrganization;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;
import ui.network.university.directorateOrganization.NetPerformance.NetPerformanceLandingPage;

/**
 *
 * @author royn
 */
public class DirectorateWorkArea extends GeneralWorkArea{

    public DirectorateWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }
   
    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton button1 = new JButton(String.format("Manage Enterprises in %s", account.getOrg().getEnterprise().getNetwork()));
        button1.addActionListener(e -> parent.pushComponent(new ManageEnterprise(parent, account)));
        buttons.add(button1);
        
        JButton button2 = new JButton(String.format("Manage Colleges in %s", account.getOrg().getEnterprise().getNetwork()));
        button2.addActionListener(e -> parent.pushComponent(new ManageCollege(parent, account)));
        buttons.add(button2);
        
        JButton button3 = new JButton(String.format("Manage Performance of %s", account.getOrg().getEnterprise().getNetwork()));
        button3.addActionListener(e -> parent.pushComponent(new NetPerformanceLandingPage(parent, account)));
        buttons.add(button3);

        JButton btnK0 = new JButton(String.format("Manage Base Coin Price of %s", account.getOrg().getEnterprise().getNetwork()));
        btnK0.addActionListener(e -> parent.pushComponent(new ManageCoinK0(account)));
        buttons.add(btnK0);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("Manage Educational Platform of %s", account.getOrg().getEnterprise().getNetwork());
    }
}
