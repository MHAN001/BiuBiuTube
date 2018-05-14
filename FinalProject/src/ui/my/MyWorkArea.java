package ui.my;

import biz.account.Account;
import biz.role.consumerRole.ViewerRole;
import ui.components.GeneralWorkArea;
import ui.components.ParentUI;

import javax.swing.*;
import java.util.ArrayList;

public class MyWorkArea extends GeneralWorkArea {

    public MyWorkArea(ParentUI parent, Account account) {
        super(parent, account);
    }

    @Override
    protected ArrayList<JButton> getButtons() {
        ArrayList<JButton> arr = new ArrayList<>();

        JButton btnTable = new JButton("All My Account(s)");
        btnTable.addActionListener(e -> parent.pushComponent(new ManageMyAccount(parent, account)));
        arr.add(btnTable);

        JButton btnChangePwd = new JButton("Change My Password");
        btnChangePwd.addActionListener(e -> parent.pushComponent(new ChangeMyPassword(account)));
        arr.add(btnChangePwd);

        JButton btnProfile = new JButton("Manage Personal Profile");
        btnProfile.addActionListener(e -> parent.pushComponent(new PersonalProfile(account)));
        arr.add(btnProfile);

        if (account.getRole() instanceof ViewerRole) {
            JButton btnCoins = new JButton("Manage Coins");
            btnCoins.addActionListener(e -> parent.pushComponent(new ManageCoinJPanel(parent, account)));
            arr.add(btnCoins);
        }


        return arr;
    }

    @Override
    public String getTitle() {
        return "Manage My Account(s)";
    }
}
