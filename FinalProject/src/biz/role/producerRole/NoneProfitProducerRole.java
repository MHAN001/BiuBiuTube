/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.role.producerRole;

import biz.account.Account;
import biz.role.Role;
import javax.swing.JPanel;
import ui.components.ParentUI;
import ui.network.nonprofitOrganizationEnterprise.videoProduceDepartment.NPOVideoProducerWorkArea;

/**
 *
 * @author 79813
 */
public class NoneProfitProducerRole extends Role{

    @Override
    public JPanel createWorkArea(ParentUI parent, Account account) {
        return new NPOVideoProducerWorkArea(parent, account);
    }    
    
}
