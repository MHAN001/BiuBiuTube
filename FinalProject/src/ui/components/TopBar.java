package ui.components;

import biz.account.Account;

import javax.swing.*;
import java.awt.*;

import biz.role.consumerRole.ViewerRole;
import ui.my.MyWorkArea;

public class TopBar extends JPanel {
    private ParentUI parent;
    private JButton btnBack;
    private LoginArea loginArea;
    private StatusArea statusArea;
    private Account account;
    private static TopBar topBar;

    private TopBar(ParentUI parent) {
        this.parent = parent;
        initComponents();
    }

    public static TopBar getInstance(ParentUI parent) {
        if (topBar == null) {
            topBar = new TopBar(parent);
        }
        return topBar;
    }

    private void initComponents() {
        setLayout(new java.awt.BorderLayout());

        loginArea = new LoginArea(parent, this);
        statusArea = new StatusArea(parent, this);

        this.btnBack = new JButton("< Back");
        this.btnBack.addActionListener(e -> parent.popComponent());
        this.btnBack.setVisible(false);

        this.add(loginArea, BorderLayout.LINE_END);
        add(btnBack, BorderLayout.LINE_START);

    }

    public void loggedIn(Account account) {
        this.account = account;
        remove(loginArea);
        String greeting = "Hello, " + account.getPerson().getFullName() + "!";
        if (account.getRole() instanceof ViewerRole) {
            if (!account.getPrimeMembership().isExpired()) {
                greeting += "(Prime Enabled)";
            }
            greeting += String.format(" Your Coins: %d", account.getWallet().getCoin());
        }
        statusArea.setGreeting(greeting);
        add(btnBack, BorderLayout.LINE_START);
        add(statusArea, BorderLayout.LINE_END);
        btnBack.setVisible(true);
        validate();
        repaint();
    }

    public void loggedOut() {
        this.account = null;
        remove(statusArea);
        btnBack.setVisible(false);
        add(loginArea, BorderLayout.LINE_END);
        validate();
        repaint();
    }

    public void manageAccount() {
        int componentCount = parent.getContainerJPanel().getComponentCount();
        JPanel jp = (JPanel) parent.getContainerJPanel().getComponent(componentCount - 1);
        for (Component c : jp.getComponents()) {
            if (c.getClass().getPackage().getName().equals("ui.my")) {
                // do nothing if top component is under ui.my
                return;
            }
        }

        parent.pushComponent(new MyWorkArea(parent, account));
    }
}
