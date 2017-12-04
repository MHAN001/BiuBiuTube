package hlp.fkr;

import biz.EcoSystem;
import biz.account.Account;
import biz.enterprises.UniversityEnterprise;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.person.Person;
import biz.video.Video;
import biz.video.VideoTag;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.HashSet;

import static hlp.fkr.CommonHelper.fakeAccount;
import static hlp.fkr.CommonHelper.fakePerson;

public class CollegeHelper {
    private static Faker faker = new Faker();
    private static String[] videoURLs = new String[]{
            "https://www.youtube.com/embed/RqvCNb7fKsg",
            "https://www.youtube.com/embed/OGxgnH8y2NM",
            "https://www.youtube.com/embed/JcI5Vnw0b2c",
            "https://www.youtube.com/embed/lN5jesocJjk",
            "https://www.youtube.com/embed/r4mwkS2T9aI",
            "https://www.youtube.com/embed/QLVMqwpOLPk",
            "https://www.youtube.com/embed/za5s7RB_VLw",
            "https://www.youtube.com/embed/V59bYfIomVk",
            "https://www.youtube.com/embed/SvmueyhSkgQ",
            "https://www.youtube.com/embed/KLGfMGsgP34",
            "https://www.youtube.com/embed/-fgYp74SNtk",
            "https://www.youtube.com/embed/QUyAFokOmow",
            "https://www.youtube.com/embed/Kpxwl2u-Wgk",
            "https://www.youtube.com/embed/44jq6ano5n0",
            "https://www.youtube.com/embed/1i0zu9jHN6U",
            "https://www.youtube.com/embed/hl3bQySs8sM",
            "https://www.youtube.com/embed/n3RqsMz3-0A",
            "https://www.youtube.com/embed/GWHG3cS2PKc",
            "https://www.youtube.com/embed/3XPhmnf96s0",
            "https://www.youtube.com/embed/r_D5TTV9-2c",
            "https://www.youtube.com/embed/mA5nwGoRAOo",
            "https://www.youtube.com/embed/Hl-zzrqQoSE",
            "https://www.youtube.com/embed/5u8rFbpdvds",
            "https://www.youtube.com/embed/CE8UIbb_4iM",
            "https://www.youtube.com/embed/SHIT5VkNrCg",
            "https://www.youtube.com/embed/gtQJXzi3Yns",
            "https://www.youtube.com/embed/5DdacOkrTgo",
            "https://www.youtube.com/embed/ANuuSFY2BbY",
            "https://www.youtube.com/embed/8ZaTSedtf9M",
            "https://www.youtube.com/embed/ydcTx6idTs0",
            "https://www.youtube.com/embed/iMeaovDbgkQ",
            "https://www.youtube.com/embed/PAaqgTr7Cx4",
            "https://www.youtube.com/embed/RVRPmeccFT0",
            "https://www.youtube.com/embed/8ZuWD2CBjgs",
            "https://www.youtube.com/embed/XqTg2buXS5o",
            "https://www.youtube.com/embed/7MBgaF8wXls",
            "https://www.youtube.com/embed/9t78g0U8VyQ",
            "https://www.youtube.com/embed/tPFuVRbUTwA",
            "https://www.youtube.com/embed/Y4xFGCyt1ww",
            "https://www.youtube.com/embed/C0YRYVn_BeI",
            "https://www.youtube.com/embed/Y6NheSwTsDs",

        //Java Class
            "https://www.youtube.com/embed/ZpBtDTCgalw",

    };
    private static String[] picPaths = new String[]{ // TODO: more pic path
            "https://i.imgur.com/ijtKGes.png",
            "https://imgur.com/51yxbFv.jpg",
            "https://imgur.com/Tq2ZOS3.jpg",
            "https://imgur.com/zkenvrm.jpg",
            "https://imgur.com/zfYeczQ.jpg",
            "https://imgur.com/FfoyzRd.jpg",
            "https://imgur.com/SaP1umA.jpg",
            "https://imgur.com/Z10Ngrw.jpg",
            "https://imgur.com/blPwucV.jpg",
            "https://imgur.com/q1CDImF.jpg",
            "https://imgur.com/2ntNoI1.jpg",
            "https://imgur.com/xlqUPP7.jpg",
            "https://imgur.com/3JZE1dj.jpg",
            "https://imgur.com/h5kFtRS.jpg",
            "https://imgur.com/c6Leyb0.jpg",
            "https://imgur.com/o9drTBT.jpg",
            "https://imgur.com/NQItmzI.jpg",
            "https://imgur.com/Jmdksc4.jpg",
            "https://imgur.com/YkvqRPD.jpg",
            "https://imgur.com/4FDqVIw.jpg",
            "https://imgur.com/JNKnrwW.jpg",
            "https://imgur.com/vxOJCDh.jpg",
            "https://imgur.com/YzwxXcU.jpg",
            "https://imgur.com/DkSBkMZ.jpg",
            "https://imgur.com/MJoQXM4.jpg",
            "https://imgur.com/aLaTt6U.jpg",
            "https://imgur.com/8oRyXq1.jpg",
            "https://imgur.com/QExsgW3.jpg",
            "https://imgur.com/UroGtj4.jpg",
            "https://imgur.com/nBGHUyO.jpg",
            "https://imgur.com/1LKnoJH.jpg",
            "https://imgur.com/ElhLH7B.jpg",
            "https://imgur.com/PRBmhAS.jpg",
            "https://imgur.com/yyayKot.jpg",
            "https://imgur.com/u2LS5OI.jpg",
            "https://imgur.com/hoBt92N.jpg"


    };

    public static UniverseCollegeOrganization fakeCollege(Network nw, HashSet<VideoTag> tags) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String collegeName = "C";
        int num = faker.random().nextInt(2) + 2;
        for (int i = 0; i < num; i++) {
            collegeName += s.charAt(faker.random().nextInt(s.length()));
        }
        UniverseCollegeOrganization college = nw.getUniversity().getCollegeCatalog().newOrganization(collegeName);

        Person p = null;
        Account a = null;

        System.out.printf("Faking college %s...\n", college);

        // 1. supervisor
        num = faker.random().nextInt(3) + 1; // 1 ~ 4 supervisor
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getUniversityDepartmentSupervisorRole());
            if (i == num - 1) {
                System.out.printf("Last supervisor account username in %s: %s\n", college, a.getUsername());
            }

            if (i > 1) {  // some of them are also lecturer
                a = fakeAccount(college.getAccountCatalog(), p, college.getCollegeLecturerRole());
            }
        }

        // 2. viewer
        num = faker.random().nextInt(500) + 20;  // 20 ~ 520 viewer
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getViewerRole());
            if (faker.random().nextInt(100) == 0) { // 1% of them are InActive
                a.setActive(false);
            }
        }
        System.out.printf("Last viewer account username in %s: %s\n", college, a.getUsername());

        // 3. lecturer
        num = faker.random().nextInt(10) + 10; // 10 ~ 20 lecturer
        for (int i = 0; i < num; i++) {
            p = fakePerson(college.getPersonCatalog());
            a = fakeAccount(college.getAccountCatalog(), p, college.getCollegeLecturerRole());
            int numVideo = faker.random().nextInt(90) + 10; // 10 ~ 100 videos
            for (int j = 0; j < numVideo; j++) {
                fakeVideo(nw, a, tags);
            }
        }
        System.out.printf("Last lecturer account username in %s: %s\n", college, a.getUsername());

        System.out.printf("College %s faked\n\n", college);

        return college;
    }


    private static Video fakeVideo(Network nw, Account account, HashSet<VideoTag> tags) {
        Video v = nw.getVideoCatalog().newVideo(account);
        String desc = "";
        for (int i = 0; i < 5; i++) {
            desc += faker.shakespeare().hamletQuote() + "\n";
        }
        v.setDescription(desc);
        v.setPicPath(picPaths[faker.random().nextInt(picPaths.length)]);
        v.setUrl(videoURLs[faker.random().nextInt(videoURLs.length)]);

        int val = faker.random().nextInt(10);
        if (val < 5) {  // 50% ESApproved
            v.setStatus(Video.VideoStatus.ESApproved);
        } else if (val < 7) {  // 20% Uploaded
            v.setStatus(Video.VideoStatus.Uploaded);
        } else if (val < 9) {  // 20% DSApproved
            v.setStatus(Video.VideoStatus.DSApproved);
        } else {  // 10% Banned
            v.setStatus(Video.VideoStatus.Banned);
        }

        val = faker.random().nextInt(4);  // 25% each ad type
        switch (val) {
            case 0:
                v.setAdType(Video.VideoAdType.NoAdd);
                break;
            case 1:
                v.setAdType(Video.VideoAdType.AnyAdd);
                break;
            case 2:
                v.setAdType(Video.VideoAdType.CommOnly);
                break;
            case 3:
                v.setAdType(Video.VideoAdType.PSAOnly);
                break;
        }

        int numTags = faker.random().nextInt(4) + 1; // 1 ~ 4 tags;
        for (int i = 0; i < numTags; i++) {
            int item = faker.random().nextInt(tags.size());
            int j = 0;
            for (VideoTag tag : tags) {
                if (item == j) {
                    v.addTag(tag);
                }
                j++;
            }
        }

        if (faker.random().nextInt(2) == 0) { // 50% prime only
            v.setPrimeOnly(true);
        }

        VideoTag tag = v.getTagHashSet().stream().findAny().orElse(null);

        String title = faker.superhero().power();
        v.setTitle(tag.getName() + " " + title);

        return v;
    }

    public static UniverseCollegeOrganization fakeCOE(Network nw){
        UniverseCollegeOrganization collegeOrganization = nw.getUniversity().getCollegeCatalog().newOrganization("COE");
        ArrayList<Person> persons = new ArrayList<>();
        String[] personLastName = {"Andrea","Alvina","Angela","Allen","Barry","Ng"};
        String[] personFirstName = {"Jack","Lois","Daniel","Kell","Hanson","Adrew"};
        Person p = null;
        String[] javaVideoList = {  "https://www.youtube.com/embed/Hl-zzrqQoSE",
                                    "https://www.youtube.com/embed/5u8rFbpdvds",
                                    "https://www.youtube.com/embed/CE8UIbb_4iM",
                                    "https://www.youtube.com/embed/SHIT5VkNrCg",
                                    "https://www.youtube.com/embed/gtQJXzi3Yns",
                                    "https://www.youtube.com/embed/5DdacOkrTgo",
                                    "https://www.youtube.com/embed/ANuuSFY2BbY",
                                    "https://www.youtube.com/embed/8ZaTSedtf9M",
                                    "https://www.youtube.com/embed/ydcTx6idTs0",
                                    "https://www.youtube.com/embed/iMeaovDbgkQ"
        };
        String[] machineLearning = {
                                    "https://www.youtube.com/embed/OGxgnH8y2NM",
                                    "https://www.youtube.com/embed/JcI5Vnw0b2c",
                                    "https://www.youtube.com/embed/lN5jesocJjk",
                                    "https://www.youtube.com/embed/r4mwkS2T9aI",
                                    "https://www.youtube.com/embed/QLVMqwpOLPk",
                                    "https://www.youtube.com/embed/za5s7RB_VLw",
                                    "https://www.youtube.com/embed/V59bYfIomVk",
                                    "https://www.youtube.com/embed/SvmueyhSkgQ",
                                    "https://www.youtube.com/embed/KLGfMGsgP34",
                                    "https://www.youtube.com/embed/-fgYp74SNtk",
        };
        String[] Ted = {
                                    "https://www.youtube.com/embed/raCIUeGUr3s" ,
                                    "https://www.youtube.com/embed/8olL43PKJKw" ,
                                    "https://www.youtube.com/embed/ptIecdCZ3dg" ,
                                    "https://www.youtube.com/embed/ppZ2WIlRvR8" ,
                                    "https://www.youtube.com/embed/2Brajdazp1o" ,
                                    "https://www.youtube.com/embed/dJEwC4wCM70" ,
                                    "https://www.youtube.com/embed/dJEwC4wCM70" ,
                                    "https://www.youtube.com/embed/8KkKuTCFvzI" ,
                                    "https://www.youtube.com/embed/NiMgOklgeos" ,
                                    "https://www.youtube.com/embed/8Dv2Hdf5TRg"


        };
        for(int i = 0 ; i < 6 ; i++){
            p = collegeOrganization.getPersonCatalog().newPerson(personFirstName[i], personLastName[i]);
            persons.add(p);
        }
        try {
            Account supervisor = collegeOrganization.getAccountCatalog().newAccount("Andrea", "1", collegeOrganization.getUniversityDepartmentSupervisorRole(), persons.get(0));
            System.out.println("COE supervisor account :  Andrea");

        } catch (Exception ex) {
            System.err.println("New supervisor failed");
        }
        try {
            Account lecturer = collegeOrganization.getAccountCatalog().newAccount("Alvina", "1", collegeOrganization.getCollegeLecturerRole() , persons.get(1));
            System.out.println("COE Lecturer account :  Alvina");

            for (int i = 0; i < 10; i++) {
                Video v = nw.getVideoCatalog().newVideo(lecturer);
                v.setTitle(String.format("JAVA-Tutorial%d", i));
                v.setAdType(Video.VideoAdType.NoAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://imgur.com/1RikGRR.jpg");
                v.setUrl(javaVideoList[i]);
                v.setDescription(String.format("java examples for beginners series"+(i+1), i));
                if (i > 3) {
                    v.setStatus(Video.VideoStatus.DSApproved);
                }

                if (i > 8) {
                    v.setStatus(Video.VideoStatus.Uploaded);
                }
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("JAVA-BASIC"));
            }

            Account lecturer1 = collegeOrganization.getAccountCatalog().newAccount("Allen", "1", collegeOrganization.getCollegeLecturerRole() , persons.get(3));
            System.out.println("COE Lecturer account :  Allen");

            for (int i = 0; i < 10; i++) {
                Video v = nw.getVideoCatalog().newVideo(lecturer1);
                v.setTitle(String.format("MachineLearning-Tutorial%d", i+1));
                v.setAdType(Video.VideoAdType.NoAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://imgur.com/Dy5n5HC.jpg");
                v.setUrl(machineLearning[i]);
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("INFO"));
                v.setDescription(String.format("machelearning examples for beginners series"+(i+1) , i));
                if (i > 2) {
                    v.setStatus(Video.VideoStatus.DSApproved);
                }

                if (i > 7) {
                    v.setStatus(Video.VideoStatus.Uploaded);
                }
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Machielearning courses"));
            }

            Account lecturer2 = collegeOrganization.getAccountCatalog().newAccount("Hanson", "1", collegeOrganization.getCollegeLecturerRole() , persons.get(4));
            System.out.println("COE Lecturer account :  Hanson");

            for (int i = 0; i < 5; i++) {
                Video v = nw.getVideoCatalog().newVideo(lecturer2);
                v.setTitle(String.format("Ted lecture%d", i+1));
                v.setAdType(Video.VideoAdType.AnyAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://imgur.com/H8JdMhf.png");
                v.setUrl(Ted[i]);
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("INFO"));
                v.setDescription(String.format("In halls of justice around the world, how can we ensure everyone is treated with dignity and respect? A pioneering judge in New Jersey, Victoria Pratt shares her principles of \"procedural justice\" -- four simple, thoughtful steps that redefined the everyday business of her courtroom in Newark, changing lives along the way. \"When the court behaves differently, naturally people respond differently,\" Pratt says. \"We want people to enter our halls of justice ... and know that justice will be served there.\"\n" +
"\n" +"Check out more TED Talks: http://www.ted.com\n" +"\n" +"The TED Talks channel features the best talks and performances from the TED Conference, where the world's leading thinkers and doers give the talk of their lives in 18 minutes (or less). Look for talks on Technology, Entertainment and Design -- plus science, business, global issues, the arts and more.", i));                
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Ted"));
            }
            for (int i = 5; i < 10; i++) {
                Video v = nw.getVideoCatalog().newVideo(lecturer2);
                v.setTitle(String.format("Ted lecture%d", i+1));
                v.setAdType(Video.VideoAdType.PSAOnly);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://imgur.com/H8JdMhf.png");
                v.setUrl(Ted[i]);
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("INFO"));
                v.setDescription(String.format("In halls of justice around the world, how can we ensure everyone is treated with dignity and respect? A pioneering judge in New Jersey, Victoria Pratt shares her principles of \"procedural justice\" -- four simple, thoughtful steps that redefined the everyday business of her courtroom in Newark, changing lives along the way. \"When the court behaves differently, naturally people respond differently,\" Pratt says. \"We want people to enter our halls of justice ... and know that justice will be served there.\"\n" +"\n" +
"Check out more TED Talks: http://www.ted.com\n" +"\n" +"The TED Talks channel features the best talks and performances from the TED Conference, where the world's leading thinkers and doers give the talk of their lives in 18 minutes (or less). Look for talks on Technology, Entertainment and Design -- plus science, business, global issues, the arts and more.", i));                
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Ted"));
                v.setPrimeOnly(true);
            }
        } catch (Exception ex) {
            System.err.println("New lecturer failed");
        }
        try {

            Account viewer = collegeOrganization.getAccountCatalog().newAccount("Angela", "1", collegeOrganization.getViewerRole(), persons.get(2));
            viewer.getWallet().modifyCoin(300);
            Account viewer2 = collegeOrganization.getAccountCatalog().newAccount("Andrew", "1", collegeOrganization.getViewerRole(), persons.get(5));
            viewer.getWallet().modifyCoin(500);
            System.out.println("COE viewer1 account :  Angela");
            System.out.println("COE viewer account :  Andrew");

        } catch (Exception ex) {
            System.err.println("New viewer failed");
        }
        System.out.println("");

        return collegeOrganization;
    }

    public static void fake(Network nw) {
        // auto fake a college with hacker abbrev tags
        // and rename it to CCIS
        HashSet<VideoTag> tags = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            String tagName = faker.hacker().abbreviation();
            tags.add(nw.getVideoTagCatalog().getOrNewTag(tagName));
        }
        UniverseCollegeOrganization college = fakeCollege(nw, tags);
        String oldName = college.getName();
        college.setName("CCIS");
        System.out.printf("College %s renamed to CCIS\n\n", oldName);

        // auto fake a college with gameOfThrones character tags
        for (int j = 0; j < 10; j++) {
            String tagName = faker.gameOfThrones().character();
            tags.add(nw.getVideoTagCatalog().getOrNewTag(tagName));
        }
        fakeCollege(nw, tags);

        // auto fake a college with gameOfThrones city tags
        tags = new HashSet<>();
        for (int j = 0; j < 10; j++) {
            String tagName = faker.gameOfThrones().city();
            tags.add(nw.getVideoTagCatalog().getOrNewTag(tagName));
        }
        fakeCollege(nw, tags);

        //True a college by Xu
        fakeCOE(nw);

//        fakeCPS(nw);
    }

    public static void fakeCPS(Network nw) {
        UniversityEnterprise university = nw.getUniversity();
        EcoSystem system = EcoSystem.getInstance();

        // manual fake college CPS
        UniverseCollegeOrganization cps = university.getCollegeCatalog().newOrganization("CPS");

        Person person;
        Account account;

        person = system.getSystemPersonCatalog().newPerson("Andy", "Zhao");
        try {
            system.getSystemAccountCatalog().newAccount("admin", "admin", system.getSystemAdminRole(), person);
        } catch (Exception ignored) {
        }

        person = cps.getPersonCatalog().newPerson("Bruce", "Qian");
        try {
            account = cps.getAccountCatalog().newAccount("qls", "qls", cps.getCollegeLecturerRole(), person);
            String[] urls = new String[]{
                    "https://www.youtube.com/embed/3XB3in9Xqy8",
                    "https://www.youtube.com/embed/3ifwR5feRQI",
                    "https://www.youtube.com/embed/qVdRxODXBcU",
                    "https://www.youtube.com/embed/wApG8SHBJ24",
                    "https://www.youtube.com/embed/dKnRUuYVR0Q",
                    "https://www.youtube.com/embed/IMhiGyxF4as",
                    "https://www.youtube.com/embed/JmiyAlvm6Ds",
                    "https://www.youtube.com/embed/mgnWYBaJuUk",
                    "https://www.youtube.com/embed/ya_kEknUNIE",
                    "https://www.youtube.com/embed/y9SvMg5CxA4",
                    "https://www.youtube.com/embed/wFgeUC5dw_4",
                    "https://www.youtube.com/embed/mSbFrQfgq7A",
                    "https://www.youtube.com/embed/j-zAbYs9J7w",
                    "https://www.youtube.com/embed/iZcfMa2Fagg",
//                  machine learning
                    "https://www.youtube.com/embed/OGxgnH8y2NM",
                    "https://www.youtube.com/embed/JcI5Vnw0b2c",
                    "https://www.youtube.com/embed/lN5jesocJjk",
                    "https://www.youtube.com/embed/r4mwkS2T9aI",
                    "https://www.youtube.com/embed/QLVMqwpOLPk",
                    "https://www.youtube.com/embed/za5s7RB_VLw",
                    "https://www.youtube.com/embed/V59bYfIomVk",
                    "https://www.youtube.com/embed/SvmueyhSkgQ",
                    "https://www.youtube.com/embed/KLGfMGsgP34",
                    "https://www.youtube.com/embed/-fgYp74SNtk",
                    "https://www.youtube.com/embed/QUyAFokOmow",
                    "https://www.youtube.com/embed/Kpxwl2u-Wgk",
                    "https://www.youtube.com/embed/44jq6ano5n0",
                    "https://www.youtube.com/embed/1i0zu9jHN6U",
                    "https://www.youtube.com/embed/hl3bQySs8sM",
                    "https://www.youtube.com/embed/n3RqsMz3-0A",
                    "https://www.youtube.com/embed/GWHG3cS2PKc",
                    "https://www.youtube.com/embed/3XPhmnf96s0",
                    "https://www.youtube.com/embed/r_D5TTV9-2c",
                    "https://www.youtube.com/embed/mA5nwGoRAOo",
//                  java tutorial
                    "https://www.youtube.com/embed/Hl-zzrqQoSE",
                    "https://www.youtube.com/embed/5u8rFbpdvds",
                    "https://www.youtube.com/embed/CE8UIbb_4iM",
                    "https://www.youtube.com/embed/SHIT5VkNrCg",
                    "https://www.youtube.com/embed/gtQJXzi3Yns",
                    "https://www.youtube.com/embed/5DdacOkrTgo",
                    "https://www.youtube.com/embed/ANuuSFY2BbY",
                    "https://www.youtube.com/embed/8ZaTSedtf9M",
                    "https://www.youtube.com/embed/ydcTx6idTs0",
                    "https://www.youtube.com/embed/iMeaovDbgkQ",
                    "https://www.youtube.com/embed/PAaqgTr7Cx4",
                    "https://www.youtube.com/embed/RVRPmeccFT0",
                    "https://www.youtube.com/embed/8ZuWD2CBjgs",
                    "https://www.youtube.com/embed/XqTg2buXS5o",
                    "https://www.youtube.com/embed/7MBgaF8wXls",
                    "https://www.youtube.com/embed/9t78g0U8VyQ",
                    "https://www.youtube.com/embed/tPFuVRbUTwA",
                    "https://www.youtube.com/embed/Y4xFGCyt1ww",
                    "https://www.youtube.com/embed/C0YRYVn_BeI",
                    "https://www.youtube.com/embed/Y6NheSwTsDs",
//                  NASA
                    "https://www.youtube.com/embed/FMhSbdoamYY",
                    "https://www.youtube.com/embed/dp4efcbqLzM",
                    "https://www.youtube.com/embed/EkbUffRtjXk",
                    "https://www.youtube.com/embed/8e4PHUByX6k",
                    "https://www.youtube.com/embed/VM5nOaLU7XM",
                    "https://www.youtube.com/embed/jWtLYScfKR0",
                    "https://www.youtube.com/embed/NeGXO01ILVA",
                    "https://www.youtube.com/embed/t21PiEIBhgs",
                    "https://www.youtube.com/embed/TDyeJ3hcCZY",
                    "https://www.youtube.com/embed/NyVz2IniF3U",
                    "https://www.youtube.com/embed/M8M9A_sV3As",
                    "https://www.youtube.com/embed/T9lh6xrPw1A",
                    "https://www.youtube.com/embed/0WZS1FMyiU8",
                    "https://www.youtube.com/embed/vKdxnSLlAcs",
                    "https://www.youtube.com/embed/p1mrhLQCJO4",
                    "https://www.youtube.com/embed/y9OZ4_T7udQ",
                    "https://www.youtube.com/embed/O1s64UGUn2k",
                    "https://www.youtube.com/embed/P6sCjXISmEU",
                    "https://www.youtube.com/embed/GR3fuigi1_g",
                    "https://www.youtube.com/embed/_ulv65FoMoc",
//                  RedCross
                    "https://www.youtube.com/embed/AFQpa2kURas",
                    "https://www.youtube.com/embed/Dm3qwVw0K-0",
                    "https://www.youtube.com/embed/ZcI3eJ3ePWY",
                    "https://www.youtube.com/embed/E1qOO-Q1iNw",
                    "https://www.youtube.com/embed/5wa-SYwgSaM",
                    "https://www.youtube.com/embed/ob5ZT-_-TFo",
                    "https://www.youtube.com/embed/28qTNTymfWY",
                    "https://www.youtube.com/embed/9nV4atXhWII",
                    "https://www.youtube.com/embed/KOlM-UkmobI",
                    "https://www.youtube.com/embed/kZqFSN2c7TA",
                    "https://www.youtube.com/embed/Y-ggSmxjhIo",
                    "https://www.youtube.com/embed/OoYnZw9Anv4",
                    "https://www.youtube.com/embed/c8ek_2oH_AY",
                    "https://www.youtube.com/embed/tWJjAlLb7KU",
                    "https://www.youtube.com/embed/iSIK7dnBEfQ",
                    "https://www.youtube.com/embed/gpH0JpevWDE",
                    "https://www.youtube.com/embed/PdgEJ6sLL0Y",
                    "https://www.youtube.com/embed/U1WF-Irwlf4",
                    "https://www.youtube.com/embed/Uclmq-mqrn8",
                    "https://www.youtube.com/embed/ZUWUllYtVWo"
            };
            for (int i = 0; i < urls.length; i++) {
                Video v = nw.getVideoCatalog().newVideo(account);
                v.setTitle(String.format("Swing Tutorial %02d", i + 1));
                v.setAdType(Video.VideoAdType.NoAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://imgur.com/a/tcTZC");
                v.setUrl(urls[i]);
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Swing"));
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("Java"));
                v.setDescription(String.format("Java Swing Tutorial %02d", i + 1));
            }
            cps.getAccountCatalog().newAccount("qlsa", "qlsa", cps.getUniversityDepartmentSupervisorRole(), person);
        } catch (Exception ignored) {
        }

        person = cps.getPersonCatalog().newPerson("Cathy", "Sun");
        try {
            account = cps.getAccountCatalog().newAccount("sls", "sls", cps.getCollegeLecturerRole(), person);
            for (int i = 1; i < 9; i++) {
                Video v = nw.getVideoCatalog().newVideo(account);
                v.setTitle(String.format("INFO5100-Lab%d", i));
                v.setAdType(Video.VideoAdType.AnyAdd);
                v.setStatus(Video.VideoStatus.ESApproved);
                v.setPicPath("https://i.imgur.com/ijtKGes.png");
                v.setUrl("https://www.youtube.com/embed/RqvCNb7fKsg");
                v.addTag(nw.getVideoTagCatalog().getOrNewTag("INFO"));
                v.setDescription(String.format("INFO5100-Lab%d Description", i));
                if (i > 3) {
                    v.setStatus(Video.VideoStatus.DSApproved);
                }

                if (i > 7) {
                    v.setStatus(Video.VideoStatus.Uploaded);
                }
            }
        } catch (Exception ignored) {
        }


        person = cps.getPersonCatalog().newPerson("Bad", "Guy");
        try {
            account = cps.getAccountCatalog().newAccount("bad", "bad", cps.getViewerRole(), person);
            account.setActive(false);
        } catch (Exception ignored) {
        }

        person = cps.getPersonCatalog().newPerson("Xiaoming", "Li");
        try {
            account = cps.getAccountCatalog().newAccount("xiaoming.li", "1", cps.getViewerRole(), person);
        } catch (Exception ignored) {
        }
        person = cps.getPersonCatalog().newPerson("Dachui", "Wang");
        try {
            account = cps.getAccountCatalog().newAccount("dachui.wang", "1", cps.getViewerRole(), person);
            university.getReloadCoinOrderCatalog().newReloadCoinOrder(account, 100, "AliPay 12345");
            account.getWallet().modifyCoin(35);
        } catch (Exception ignored) {
        }

    }
}
