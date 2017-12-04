/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.departmentSupervisor;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author hezj
 */
public class DepartmentSupervisorWorkArea extends GeneralWorkArea {

    public DepartmentSupervisorWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton button = new JButton(String.format("Censor Video Uploaded in %s", account.getOrg()));
        button.addActionListener(e -> parent.pushComponent(new CensorVideos(parent, account)));
        buttons.add(button);

        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("%s Department Supervisor WorkArea", account.getOrg().getEnterprise());
    }
    
}
