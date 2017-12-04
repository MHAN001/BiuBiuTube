/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author hezj
 */
public class DemoWorkArea extends GeneralWorkArea {

    public DemoWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> btnArrayList = new ArrayList<>();
        
        JButton btn = new JButton("Manage Foobar");
        btn.addActionListener(e -> parent.pushComponent(new DemoJPanel(parent)));
        btnArrayList.add(btn);
        
        btn = new JButton("Manage A Very Very Very Very Very Very Very Very Very Very Very Very Long Title");
        btn.addActionListener(e -> parent.pushComponent(new DemoJPanel(parent)));
        btnArrayList.add(btn);        

        return btnArrayList;
    }

    @Override
    public String getTitle() {
        return "Demo Work Area";
    }
    
}
