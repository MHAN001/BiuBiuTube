package ui.my;

import biz.account.Account;
import biz.enterprises.UniversityEnterprise;
import ui.components.ChildComponent;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.UnEditableTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ManageCoinJPanel extends JPanel implements HasTitle, ChildComponent {
    private Account account;
    private JTable tblReloadCoinOrder;
    private JTable tblWalletHistory;
    private ParentUI parent;

    ManageCoinJPanel(ParentUI parent, Account account) {
        this.account = account;
        this.parent = parent;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        JPanel footer = new JPanel();
        add(footer, BorderLayout.PAGE_END);
        footer.setLayout(new GridBagLayout());
        GridBagConstraints footerConstraints = new GridBagConstraints();
        footerConstraints.fill = GridBagConstraints.HORIZONTAL;
        footerConstraints.gridx = 0;
        footerConstraints.gridy = 0;
        footerConstraints.weightx = 1.0;

        JButton btnReload = new JButton("Order More Coins >>");
        btnReload.addActionListener(e -> parent.pushComponent(new ReloadCoinJPanel(account)));
        footer.add(btnReload, footerConstraints);

        JButton btnRedeem = new JButton("Redeem  >>");
        btnRedeem.addActionListener(e -> parent.pushComponent(new RedeemJPanel(parent, account)));
        footerConstraints.gridy = 1;
        footer.add(btnRedeem, footerConstraints);

        JSplitPane splitPane = new JSplitPane();
//        splitPane.setEnabled(false);
        splitPane.setDividerLocation(494);
        add(splitPane);

        tblReloadCoinOrder = new JTable(new UnEditableTableModel(new String[] {
                "Created At",
                "Status",
                "Status Comment",
                "Updated At"
        }));

        JScrollPane reloaCoinOrderScrollPane = new JScrollPane();
        reloaCoinOrderScrollPane.setViewportView(tblReloadCoinOrder);
        reloaCoinOrderScrollPane.setBorder(BorderFactory.createTitledBorder("Coin Reload Orders"));
        splitPane.setLeftComponent(reloaCoinOrderScrollPane);

        this.tblWalletHistory = new JTable(new UnEditableTableModel(new String[] {
                "Time",
                "Value",
        }));
        JScrollPane WalletHistoryScrollPane = new JScrollPane();
        WalletHistoryScrollPane.setViewportView(tblWalletHistory);
        WalletHistoryScrollPane.setBorder(BorderFactory.createTitledBorder("My Wallet History"));
        splitPane.setRightComponent(WalletHistoryScrollPane);

        populateTables();
    }

    @Override
    public void exposed() {
        populateTables();
    }

    private void populateTables() {
        populateWalletHistoryTable();
        populateReloadCoinOrderTable();
    }

    private void populateReloadCoinOrderTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblReloadCoinOrder.getModel();
        dtm.setRowCount(0);
        UniversityEnterprise university = (UniversityEnterprise) account.getOrg().getEnterprise();
        university.getReloadCoinOrderCatalog().getReloadOrderArrayList().forEach(reloadCoinOrder -> {
            if (reloadCoinOrder.getViewer().equals(account)) {
                dtm.addRow(new Object[]{
                        reloadCoinOrder,
                        reloadCoinOrder.getStatus(),
                        reloadCoinOrder.getStatus().getComment(),
                        reloadCoinOrder.getUpdatedAt().getTime()
                });
            }
        });
    }

    private void populateWalletHistoryTable() {
        DefaultTableModel dtm = (DefaultTableModel) tblWalletHistory.getModel();
        dtm.setRowCount(0);
        account.getWallet().getHistoryArrayList().forEach(history -> dtm.addRow(new Object[] {
                history.getCalendar().getTime(),
                String.format("%+d", history.getAmount()),
        }));
    }

    @Override
    public String getTitle() {
        return "Manage Coins";
    }
}
