/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.extraCurricularOrganizationEnterprise.supervisorOrganization;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;
import ui.network.university.college.departmentSupervisor.CensorVideos;

/**
 *
 * @author royn
 */
public class ECOSupervisorWorkArea extends GeneralWorkArea{

    public ECOSupervisorWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton button = new JButton(String.format("Censor Video Uploaded in %s", account.getOrg().getEnterprise()));
        button.addActionListener(e -> parent.pushComponent(new CensorVideos(parent, account)));
        buttons.add(button);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("%s ECO Supervisor WorkArea", account.getOrg().getEnterprise());
    }
}
