package biz.video;

import biz.account.Account;

import java.util.ArrayList;

public class ReportCatalog {
    private Video video;
    private ArrayList<Report> reportArrayList;

    public ReportCatalog(Video video) {
        this.video = video;
        reportArrayList = new ArrayList<>();
    }

    public ArrayList<Report> getReportArrayList() {
        return reportArrayList;
    }

    public Report newReport(Account account, String message) {
        Report report = new Report(video, account, message);
        this.reportArrayList.add(report);
        return report;
    }
}
