/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.role;

import biz.account.Account;
import javax.swing.JPanel;
import ui.components.ParentUI;

/**
 *
 * @author 79813
 */
public abstract class Role {
    
    public abstract JPanel createWorkArea(ParentUI parent, Account account);
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName().substring(0, this.getClass().getSimpleName().length()-4);
    }
}
