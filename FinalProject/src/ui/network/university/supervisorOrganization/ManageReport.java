package ui.network.university.supervisorOrganization;

import biz.account.Account;
import biz.video.Video;
import ui.components.HasTitle;
import ui.components.ParentUI;
import ui.components.TablePopulatable;
import ui.components.UnEditableTableModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Comparator;

public class ManageReport extends JPanel implements TablePopulatable<Video>, HasTitle {
    private Account account;
    private ParentUI parent;
    private JTable tblVideo;
    private JTable tblReport;
    private JSplitPane splitPane;

    public ManageReport(ParentUI parent, Account account) {
        this.parent = parent;
        this.account = account;
        initComponents();
        populateTable();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        splitPane = new JSplitPane();
        add(splitPane);

        tblVideo = new JTable(new UnEditableTableModel(new String[]{
                "Title",
                "Lecturer",
                "Organization",
                "Report Count"
        }));
        JScrollPane videoPane = new JScrollPane();
        videoPane.setViewportView(tblVideo);
        videoPane.setBorder(BorderFactory.createTitledBorder("Videos"));
        splitPane.setLeftComponent(videoPane);
        tblVideo.getSelectionModel().addListSelectionListener(x -> {
            if (tblVideo.getSelectedRows().length != 1) {
                return;
            }
            Video v = getSelected();
            if (v != null) {
                populateReportTable(v);
            }
        });


        tblReport = new JTable(new UnEditableTableModel(new String[]{
                "Report Time",
                "Reporter",
                "Message",
        }));
        JScrollPane reportPane = new JScrollPane();
        reportPane.setViewportView(tblReport);
        reportPane.setBorder(BorderFactory.createTitledBorder("Reports(Click on Videos table to show)"));
        splitPane.setRightComponent(reportPane);

        JButton btnWatch = new JButton("Censor Selected >>");
        btnWatch.addActionListener(e -> {
            Video video = getSelected();
            if (video == null) {
                return;
            }
            parent.pushComponent(new WatchReportedVideo(parent, video));
        });
        add(btnWatch, BorderLayout.PAGE_END);
    }

    @Override
    public String getTitle() {
        return String.format("Reported Videos in %s", account.getOrg().getEnterprise());
    }

    @Override
    public JTable getTable() {
        return tblVideo;
    }

    public void populateReportTable(Video video) {
        DefaultTableModel dtm = (DefaultTableModel) tblReport.getModel();
        dtm.setRowCount(0);
        if (video == null) {
            return;
        }

        video.getReportCatalog().getReportArrayList()
                .stream()
                .filter(report -> !report.isDeleted())
                .forEach(report -> dtm.addRow(new Object[]{
                        report,
                        report.getAccount().getPerson(),
                        report.getMessage()
                }));
    }

    @Override
    public Object[] populateRow(Video video) {
        return new Object[]{
                video,
                video.getUploaderAccount().getPerson(),
                video.getUploaderAccount().getPerson().getOrg(),
                video.getReportCatalog().getReportArrayList().size()
        };
    }

    @Override
    public void populateTable() {
        populateTable(account.getOrg().getEnterprise().getNetwork().getVideoCatalog().getVideoArrayList().stream()
                .filter(video -> video.getReportCatalog().getReportArrayList().stream().filter(report -> !report.isDeleted()).count() > 0)
                .sorted(Comparator.comparingInt((Video v) -> v.getReportCatalog().getReportArrayList().size()).reversed())
        );
        populateReportTable(null);
    }
}
