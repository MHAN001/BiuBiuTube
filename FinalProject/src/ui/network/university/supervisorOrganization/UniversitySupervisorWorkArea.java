/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.supervisorOrganization;

import biz.account.Account;
import java.util.ArrayList;
import javax.swing.JButton;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;
import ui.network.advertisementEnterprise.supervisorOrganization.CensorAdvertisements;
import ui.network.university.college.departmentSupervisor.CensorVideos;
import ui.network.university.saleOrganization.SalesManager.CensorContracts;

/**
 *
 * @author hezj
 */
public class UniversitySupervisorWorkArea extends GeneralWorkArea {

    public UniversitySupervisorWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();

        JButton btnSignupRequest = new JButton(String.format("Manage Signup Request in %s", account.getOrg().getEnterprise()));
        btnSignupRequest.addActionListener(e -> parent.pushComponent(new ManageSignup(parent, account)));
        buttons.add(btnSignupRequest);


        JButton btnVideo = new JButton(String.format("Censor Video Uploaded in %s", account.getOrg().getEnterprise().getNetwork()));
        btnVideo.addActionListener(e -> parent.pushComponent(new CensorVideos(parent, account)));
        buttons.add(btnVideo);

        JButton btnAd = new JButton(String.format("Censor Ad Uploaded in %s", account.getOrg().getEnterprise().getNetwork()));
        btnAd.addActionListener(e -> parent.pushComponent(new CensorAdvertisements(parent, account)));
        buttons.add(btnAd);

        JButton btnReport = new JButton("Manage Report");
        btnReport.addActionListener(e -> parent.pushComponent(new ManageReport(parent, account)));
        buttons.add(btnReport);
        
        JButton btnContract = new JButton("Manage Contract");
        btnContract.addActionListener(l -> parent.pushComponent(new CensorContracts(parent, account)));
        buttons.add(btnContract);

        return buttons;
    }

    @Override
    public String getTitle() {
        return String.format("%s Supervisor Work Area", account.getOrg().getEnterprise());
    }
    
}
