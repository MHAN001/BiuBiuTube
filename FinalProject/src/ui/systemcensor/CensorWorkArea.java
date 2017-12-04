/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.systemcensor;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author 79813
 */
public class CensorWorkArea extends GeneralWorkArea{

    public CensorWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton btnManageReports = new JButton("Manage Reports");
//        btnManageReports.addActionListener(e -> parent.pushComponent(new ManageRepor));


        return buttons;
    }

    @Override
    public String getTitle() {
        return "Censor WorkArea";
    }
    
}
