/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hlp.fkr;

import biz.account.Account;
import biz.ad.Ad;
import biz.enterprises.AdCompanyEnterprise;
import static hlp.fkr.CommonHelper.fakeAccount;
import static hlp.fkr.CommonHelper.fakePerson;

import biz.fnc.AdViewsOrder;
import biz.nw.Network;
import biz.org.adc.AdvertiseProduceOrganization;
import biz.person.Person;
import com.github.javafaker.Faker;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author royn
 */
public class AdEnterpriseHelper {

    private static Faker faker = new Faker();
    private static String[] videoURLs = new String[]{
        "https://www.youtube.com/embed/K9vFWA1rnWc?autoplay=1",
        "https://www.youtube.com/embed/R59TevgzN3k?autoplay=1"
    };
    private static String[] picPaths = new String[]{ 
        "https://i.imgur.com/ijtKGes.png",
        "https://imgur.com/ePLB9mY.jpg",
        "https://imgur.com/jbR9Lw7.jpg",
        "https://imgur.com/4InctY4.jpg",
        "https://imgur.com/rhxICN9.jpg",
        "https://imgur.com/ffKJaQF.jpg",
        "https://imgur.com/0F552hw.jpg",
        "https://imgur.com/sccXANz.jpg",
        "https://imgur.com/fq0RKPt.jpg",
        "https://imgur.com/oa0lD02.jpg",
        "https://imgur.com/EtrK23p.jpg",
        "https://imgur.com/Ui2KfOy.jpg",
        "https://imgur.com/zPN4w2M.jpg",
        "https://imgur.com/hbKEzFN.jpg",
        "https://imgur.com/G6u4Eqr.jpg",
        "https://imgur.com/RRjaRaR.jpg",
        "https://imgur.com/LUYyYmq.jpg",
        "https://imgur.com/FOcx22R.jpg",
        "https://imgur.com/JlVFryF.jpg",
        "https://imgur.com/MfEJc1w.jpg",
        "https://imgur.com/268T8Ts.jpg",
        "https://imgur.com/akMraub.jpg",
        "https://imgur.com/QW9d7p9.jpg",
        "https://imgur.com/AVltpoU.jpg",
        "https://imgur.com/TEKozgO.jpg",
        "https://imgur.com/9hEuQRD.jpg",
        "https://imgur.com/LO9zjVK.jpg",
        "https://imgur.com/W6pKYWt.jpg",
        "https://imgur.com/CEm661Y.jpg",
        "https://imgur.com/GeCU1qF.jpg",
        "https://imgur.com/ng6V3kP.jpg",
        "https://imgur.com/rS8VNPs.jpg",
        "https://imgur.com/LpWaeXV.jpg",
        "https://imgur.com/O0xkVN4.jpg",
        "https://imgur.com/FyH2gr4.jpg",
        "https://imgur.com/RUg26i4.jpg",
        "https://imgur.com/PdVPJVd.jpg",
        "https://imgur.com/MqFvlbe.jpg",
       
    };

    private static AdvertiseProduceOrganization fakeProduceOrganization(AdCompanyEnterprise enterprise) {
        AdvertiseProduceOrganization org =  enterprise.getaPCatalog().newOrganization("Random Name");
        
        // 1.producer
        Person p = null;
        Account a = null;
        
        
        
        int num = faker.random().nextInt(3) + 1; // 1 ~ 4 producer
        for (int i = 0; i < num; i++) {
            p = fakePerson(org.getPersonCatalog());
            a = fakeAccount(org.getAccountCatalog(), p, ((AdvertiseProduceOrganization) org).getAdProducerRole());
            int numAd = faker.random().nextInt(10) + 10; // 10 ~ 20 advertisements
            for (int j = 0; j < numAd; j++) {
                fakeAd(enterprise.getNetwork(), a);
            }
            
        }
        System.out.println(String.format("last ad producer account username: %s", a.getUsername()));
        
        return org;
    }
    
    //fake ad for every producer
    private static Ad fakeAd(Network nw, Account account) {
        Ad ad = nw.getAdCatalog().newAd(account);
        String desc = "";
        for (int i = 0; i < 5; i++) {
            desc += faker.shakespeare().romeoAndJulietQuote() + "\n";
        }
        
        ad.setDescription(desc);
        ad.setUrl(videoURLs[faker.random().nextInt(videoURLs.length)]);
        
        String title = faker.gameOfThrones().dragon();
        ad.setTitle(title);
        
        int val = faker.random().nextInt(10);
        if (val < 5) {  // 50% ESApproved
            ad.setStatus(Ad.AdStatus.ESApproved);
        } else if (val < 7) {  // 20% Produced
            ad.setStatus(Ad.AdStatus.Produced);
        } else if (val < 9) {  // 20% NSApproved
            ad.setStatus(Ad.AdStatus.NSApproved);
        } else {  // 10% Banned
            ad.setStatus(Ad.AdStatus.Banned);
        }
        
        return ad;
    }
    
    public static AdCompanyEnterprise fakeAdEnterprise(Network nw) {
        String companyName = faker.company().name();
        AdCompanyEnterprise adcompany = nw.getAdCompanyCatalog().newEnterprise(companyName);

        Person p = null;
        Account a = null;
        
        System.out.printf("Faking advertisement company %s...\n", adcompany);

        int num;
        num = faker.random().nextInt(2) + 1;  // 1 ~ 3 producer org
        for (int i = 0; i < num; i++) {
            fakeProduceOrganization(adcompany);
        }
        
        // 2. supervisor
        num = faker.random().nextInt(3) + 1; // 1 ~ 4 supervisor
        for (int i = 0; i < num; i++) {
            p = fakePerson(adcompany.getaSupervisor().getPersonCatalog());
            a = fakeAccount(adcompany.getaSupervisor().getAccountCatalog(), p, adcompany.getaSupervisor().getAdCompanySupervisorRole());  
        }
        System.out.println(String.format("Last ad supervisor account username: %s", a.getUsername()));
        
        // 3. admin
        num = faker.random().nextInt(3) + 1; // 1 ~ 4 admin
        for (int i = 0; i < num; i++) {
            p = fakePerson(adcompany.getaAdmin().getPersonCatalog());
            a = fakeAccount(adcompany.getaAdmin().getAccountCatalog(), p, adcompany.getaAdmin().getAdAdminRole());  
        }
        System.out.println(String.format("Last ad admin account username: %s", a.getUsername()));
        
        // 4. accounting
        p = fakePerson(adcompany.getaAccount().getPersonCatalog());
        a = fakeAccount(adcompany.getaAccount().getAccountCatalog(), p, adcompany.getaAccount().getAdvertiseAccountingRole());
        System.out.printf("Last ad accounting username: %s\n", a.getUsername());

        // 5. order
        AdViewsOrder order = null;
        for (int i = 0; i < 50; i++) {  // fake 3 orders
             order = adcompany.getAdViewsOrderCatalog().newAdViewsOrder(2000, String.format("Payment %02d", i));
            if (i < 48) {
                try {
                    order.approve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.printf("Last order: %s\n", order);

        System.out.printf("Advertisement company %s faked\n\n", adcompany);
        return adcompany;
    }

    public static void fake(Network nw) {
        fakeAdEnterprise(nw);
    }
}
