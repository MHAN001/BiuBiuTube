/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import biz.account.Account;
import java.awt.Component;
import java.awt.Font;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author hezj
 */
public abstract class GeneralWorkArea extends JPanel implements HasTitle {
    protected abstract ArrayList<JButton> getButtons();
    protected ParentUI parent;
    protected Account account;
    
    public GeneralWorkArea(ParentUI parent, Account account) {
        this.parent = parent;
        this.account = account;
        initComponents();
    }
    
    public void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        ArrayList<JButton> buttons = getButtons();
        for (int i = 0; i < buttons.size(); i++) {
            JButton btn = buttons.get(i);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            Font f = btn.getFont();
            btn.setFont(new Font(f.getName(), f.getStyle(), 16));
            btn.setSize(btn.getSize());
            add((Component) btn);
        }
    }
}
