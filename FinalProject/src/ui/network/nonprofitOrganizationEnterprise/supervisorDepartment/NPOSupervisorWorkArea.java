/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.nonprofitOrganizationEnterprise.supervisorDepartment;

import ui.network.advertisementEnterprise.supervisorOrganization.CensorAdvertisements;
import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

/**
 *
 * @author royn
 */
public class NPOSupervisorWorkArea extends GeneralWorkArea{

    public NPOSupervisorWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        
        JButton button = new JButton(String.format("Censor Advertisement Uploaded by %s", account.getOrg().getEnterprise()));
        button.addActionListener(e -> parent.pushComponent(new CensorAdvertisements(parent, account)));
        buttons.add(button);
        
        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("%s NPO Supervisor Work Area", account.getOrg().getEnterprise());
    }
    
}
