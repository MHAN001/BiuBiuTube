package biz.ad;

import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import biz.role.producerRole.AdvertisementProducerRole;
import biz.role.producerRole.NoneProfitProducerRole;
import java.util.Calendar;

public class Ad {
    private String title;
    private Account producer;
    private AdStatus status;
    private AdType type;
    private String description;
    private String url;
    private Calendar createdAt;
    private AdHistoryCatalog adHistoryCatalog;

    public enum AdStatus {
        Produced("Produced", "Advertisement is produced, waiting organization supervisor to approve."),
        ESApproved("Enterprise Supervisor Approved", "Advertisement is approved by enterprise supervisor, waiting university supervisor to approve."),
        NSApproved("Network Supervisor Approved", "Advertisement is approved by network supervisor, ready to go."),
        Banned("Banned", "Advertisement is banned according to censorship");

        private String name;
        private String description;

        AdStatus(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    public enum AdType {
        CommercialAd("Commercial Advertisement"),
        PSAd("Public Service Advertisement");

        private String name;

        AdType(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Calendar getCreatedAt() {
        return createdAt;
    }

    Ad(Account account) {
        this.producer = account;
        this.status = AdStatus.Produced;
        if (account.getRole() instanceof NoneProfitProducerRole) {
            this.type = AdType.PSAd;
        } else if (account.getRole() instanceof AdvertisementProducerRole) {
            this.type = AdType.CommercialAd;
        }
        this.description = "";
        this.createdAt = Calendar.getInstance();
        this.adHistoryCatalog = new AdHistoryCatalog(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public AdStatus getStatus() {
        return status;
    }

    public void setStatus(AdStatus status) {
        this.status = status;
    }

    public Account getProducer() {
        return producer;
    }

    public AdType getType() {
        return type;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return title;
    }

    public AdHistoryCatalog getAdHistoryCatalog() {
        return adHistoryCatalog;
    }    

    public void view(Account viewer) {
        AdCompanyEnterprise company = (AdCompanyEnterprise)producer.getOrg().getEnterprise();
        if (company.getRemainingAdViews() <= 0) {
            return;
        }
        adHistoryCatalog.newAdHistory(viewer);
        company.setRemainingAdViews(company.getRemainingAdViews() - 1);
    }
}
