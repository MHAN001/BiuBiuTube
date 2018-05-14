package biz.nw;

import biz.ad.AdCatalog;
import biz.contract.ContractCatalog;
import biz.enterprises.AdCompanyEnterpriseCatalog;
import biz.enterprises.ECOEnterpriseCatalog;
import biz.enterprises.NPOEnterpriseCatalog;
import biz.enterprises.UniversityEnterprise;
import biz.video.VideoCatalog;
import biz.video.VideoTagCatalog;

public class Network {
    private VideoCatalog videoCatalog;
    private AdCatalog adCatalog;

    private VideoTagCatalog videoTagCatalog;

    private UniversityEnterprise university;
    private ECOEnterpriseCatalog ecoCatalog;
    private AdCompanyEnterpriseCatalog adCompanyCatalog;
    private NPOEnterpriseCatalog npoCatalog;

    private ContractCatalog contractCatalog;

    private String name;

    private double k0;

    public Network(String name) {
        this.name = name;
        this.university = new UniversityEnterprise(name, this);
        this.videoCatalog = new VideoCatalog(this);
        this.adCatalog = new AdCatalog(this);

        this.videoTagCatalog = new VideoTagCatalog(this);

        this.ecoCatalog = new ECOEnterpriseCatalog(this);
        this.adCompanyCatalog = new AdCompanyEnterpriseCatalog(this);
        this.npoCatalog = new NPOEnterpriseCatalog(this);
        this.contractCatalog = new ContractCatalog(this);

        k0 = 0.1;
    }

    @Override
    public String toString() {
        return name;
    }

    public VideoCatalog getVideoCatalog() {
        return videoCatalog;
    }

    public AdCatalog getAdCatalog() {
        return adCatalog;
    }

    public UniversityEnterprise getUniversity() {
        return university;
    }

    public ECOEnterpriseCatalog getEcoCatalog() {
        return ecoCatalog;
    }

    public AdCompanyEnterpriseCatalog getAdCompanyCatalog() {
        return adCompanyCatalog;
    }

    public NPOEnterpriseCatalog getNpoCatalog() {
        return npoCatalog;
    }

    public VideoTagCatalog getVideoTagCatalog() {
        return videoTagCatalog;
    }

    public ContractCatalog getContractCatalog() {
        return contractCatalog;
    }

    public double getK0() {
        return k0;
    }

    public void setK0(double k0) {
        this.k0 = k0;
    }

    public double getCoinPrice(int quantity) {
        if (quantity < 50) {
            return k0 * quantity;
        }

        if (quantity < 250) {
            return k0 * 50 + k0 * (quantity - 50) * 0.8;
        }

        if (quantity < 1250) {
            return k0 * 50 + k0 * 200 * 0.8 + k0 * (quantity - 250) * 0.6;
        }

        return k0 * 50 + k0 * 200 * 0.8 + k0 * 1000 * 0.6 + k0 * (quantity - 1250) * 0.4;
    }
    
    
    public int getTotalVideoNumber(){
        return videoCatalog.getVideoArrayList().size();
    }
    
    
}
