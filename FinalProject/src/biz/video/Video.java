package biz.video;

import biz.account.Account;
import biz.ad.Ad;
import biz.ad.AdCatalog;
import biz.nw.Network;

import java.util.Calendar;
import java.util.HashSet;

public class Video {
    private Calendar createdAt;
    private Account uploaderAccount;
    private VideoAdType adType;
    private VideoStatus status;
    private VoteCatalog voteCatalog;
    private CommentCatalog commentCatalog;
    private ViewHistoryCatalog viewHistoryCatalog;
    private ReportCatalog reportCatalog;
    private String title;
    private String description;
    private String picPath;
    private String url;
    private HashSet<VideoTag> tagHashSet;
    private boolean isPrimeOnly;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ReportCatalog getReportCatalog() {
        return reportCatalog;
    }

    public enum VideoAdType {
        NoAdd("No Advertisement"),
        AnyAdd("Any Advertisement"),
        CommOnly("Commercial Advertisements Only"),
        PSAOnly("PSAs Only");

        VideoAdType(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum VideoStatus {
        Uploaded("Uploaded", "Video uploaded, waiting department supervisor to approve."),
        DSApproved("Department Supervisor Approved", "Video is approved by department supervisor, waiting enterprise supervisor to approve."),
        ESApproved("Enterprise Supervisor Approved", "Video is approved by enterprise supervisor, it can be viewed"),
        Banned("Banned", "Video is banned according to censorship");

        String title;
        String description;

        VideoStatus(String title, String description) {
            this.title = title;
            this.description = description;
        }

        @Override
        public String toString() {
            return this.title;
        }

        public String getDescription() {
            return description;
        }

        public String getTitle() {
            return title;
        }
    }

    public VideoAdType getAdType() {
        return adType;
    }

    public Account getUploaderAccount() {
        return uploaderAccount;
    }

    public void setAdType(VideoAdType adType) {
        this.adType = adType;
    }

    public VoteCatalog getVoteCatalog() {
        return voteCatalog;
    }

    public CommentCatalog getCommentCatalog() {
        return commentCatalog;
    }

    public ViewHistoryCatalog getViewHistoryCatalog() {
        return viewHistoryCatalog;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean canView() {
        return this.status.equals(VideoStatus.ESApproved);
    }

    public void addTag(VideoTag tag) {
        this.tagHashSet.add(tag);
    }

    public void removeTag(VideoTag tag) {
        this.tagHashSet.remove(tag);
    }

    public void removeAllTag() {
        this.tagHashSet = new HashSet<>();
    }

    public HashSet<VideoTag> getTagHashSet() {
        return tagHashSet;
    }

    public VideoStatus getStatus() {
        return status;
    }

    public void setStatus(VideoStatus status) {
        this.status = status;
    }

    public String getPicPath() {
//        return "https://i.imgur.com/ijtKGes.png";
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public boolean isPrimeOnly() {
        return isPrimeOnly;
    }

    public void setPrimeOnly(boolean primeOnly) {
        isPrimeOnly = primeOnly;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    Video(Account uploaderAccount) {
        this.uploaderAccount = uploaderAccount;
        this.voteCatalog = new VoteCatalog(this);
        this.commentCatalog = new CommentCatalog(this);
        this.viewHistoryCatalog = new ViewHistoryCatalog(this);
        this.reportCatalog = new ReportCatalog(this);
        this.tagHashSet = new HashSet<>();
        this.adType = VideoAdType.NoAdd;  // default no ad
        this.status = VideoStatus.Uploaded;
        this.title = "";
        this.description = "";
        this.isPrimeOnly = false;
        this.createdAt = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return title;
    }

    public Ad getAd() {
        AdCatalog adCatalog = uploaderAccount.getOrg().getEnterprise().getNetwork().getAdCatalog();
        switch (adType) {
            case AnyAdd:
                return adCatalog.randomAd();
            case PSAOnly:
                return adCatalog.randomAd(Ad.AdType.PSAd);
            case CommOnly:
                return adCatalog.randomAd(Ad.AdType.CommercialAd);
        }
        return null;
    }

    public void view(Account viewer) {
        viewHistoryCatalog.newViewHistory(viewer);
        Ad ad = getAd();
        if (ad != null) {
            ad.view(viewer);
        }
    }
}
