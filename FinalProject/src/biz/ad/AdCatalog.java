package biz.ad;


import biz.account.Account;
import biz.enterprises.AdCompanyEnterprise;
import biz.nw.Network;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class AdCatalog {
    private Network network;
    private ArrayList<Ad> adArrayList;
    private Random random;

    public AdCatalog(Network network) {
        this.network = network;
        this.adArrayList = new ArrayList<>();
        random = new Random();
    }

    public Ad newAd(Account account) {
        Ad ad = new Ad(account);
        this.adArrayList.add(ad);
        return ad;
    }

    public Network getNetwork() {
        return network;
    }

    public ArrayList<Ad> getAdArrayList() {
        return adArrayList;
    }

    public Stream<Ad> getStream(Ad.AdType type) {
        return adArrayList.stream()
                .filter(ad -> ad.getStatus().equals(Ad.AdStatus.NSApproved))
                .filter(ad -> ad.getType().equals(type))
                .filter(ad -> ((AdCompanyEnterprise) ad.getProducer().getOrg().getEnterprise()).getRemainingAdViews() > 0);
    }

    public Ad randomAd(Ad.AdType type) {
        Ad ad = null;
        int total = (int) getStream(type).count();
        if (total > 0) {
            ad = getStream(type).skip(random.nextInt(total)).findFirst().orElse(null);
        }
        return ad;
    }

    public Ad randomAd() {
        Ad ad;

        if (random.nextInt(10) > 2) {  // 70% Commercial
            ad = randomAd(Ad.AdType.CommercialAd);
            if (ad == null) {
                return randomAd(Ad.AdType.PSAd);
            }
        } else {  // 30% PSAs
            ad = randomAd(Ad.AdType.PSAd);
            if (ad == null) {
                return randomAd(Ad.AdType.CommercialAd);
            }
        }

        return ad;
    }
}
