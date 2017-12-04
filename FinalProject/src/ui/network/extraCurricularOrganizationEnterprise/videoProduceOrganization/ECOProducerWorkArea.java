/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.extraCurricularOrganizationEnterprise.videoProduceOrganization;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;
import ui.network.university.college.Lecturer.ManageVideo;

/**
 *
 * @author royn
 */
public class ECOProducerWorkArea extends GeneralWorkArea {

    public ECOProducerWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();

        JButton btn = new JButton("Manage Video");
        btn.addActionListener(e -> parent.pushComponent(new ManageVideo(parent, account)));
        buttons.add(btn);

        return buttons;
    }

    @Override
    public String getTitle() {
        return "Lecturer Work Area";
    }
}
