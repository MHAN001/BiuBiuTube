package hlp.fkr;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.video.Video;

import java.util.ArrayList;

import static hlp.fkr.ReportHelper.faker;

public class ViewHelper {
    public static void fake(Network nw) {
        System.out.println("Fake views, comments, votes and reports");
        nw.getVideoCatalog().getVideoArrayList().forEach(ViewHelper::fakeViewForVideo);

        for (UniverseCollegeOrganization college: nw.getUniversity().getCollegeCatalog().getOrganizations()) {
            if (college.getName().equals("CCIS")) {
                System.out.println("Fake extra 1000 reports in CCIS");
                ReportHelper.fakeReports(college, 1000);
            }
        }
        System.out.println();
    }

    private static void fakeViewForVideo(Video v) {
        if (v.getStatus().equals(Video.VideoStatus.ESApproved)) {  // fake view for ESApproved video
            for (int i = 0; i < faker.random().nextInt(400) + 100; i++) {  // 100 ~ 500 view
                Account viewer = randomViewerForVideo(v);
                v.view(viewer);
                if (faker.random().nextInt(4) == 0) {  // 25% to vote
                    try {
                        v.getVoteCatalog().newVote(viewer);
                    } catch (Exception ignored) {
                    }
                }
                if (faker.random().nextInt(5) == 0) {  // 20% to comment
                    try {
                        v.getCommentCatalog().newComment(viewer, faker.shakespeare().asYouLikeItQuote());
                    } catch (Exception ignored) {
                    }
                }
                if (faker.random().nextInt(1000) == 0) { // 0.1% to report
                    v.getReportCatalog().newReport(viewer, faker.shakespeare().romeoAndJulietQuote());
                }
            }
        }

    }

    private static Account randomViewerForVideo(Video video) {
        Network nw = video.getUploaderAccount().getOrg().getEnterprise().getNetwork();
        UniverseCollegeOrganization college;

        if (faker.random().nextInt(2) == 0) {  // 50% chance from same college
            college = (UniverseCollegeOrganization) video.getUploaderAccount().getOrg();
        } else {  // 50% chance random
            ArrayList<UniverseCollegeOrganization> collegeArrayList = nw.getUniversity().getCollegeCatalog().getOrganizations();
            college = collegeArrayList.get(faker.random().nextInt(collegeArrayList.size()));
        }

        Object[] arr = college.getAccountCatalog().getAccountArrayList().stream()
                .filter(acc -> acc.getRole().equals(college.getViewerRole())).toArray();
        return (Account) arr[faker.random().nextInt(arr.length)];
    }

    private static void fakeComment(Video video, int num) {
        for (int i = 0; i < num; i++) {
            Account account = randomViewerForVideo(video);
            String comment = faker.shakespeare().asYouLikeItQuote();
            video.getCommentCatalog().newComment(account, comment);
        }
    }

    private static void fakeVote(Video video, int num) {
        for (int i = 0; i < num; i++) {
            Account account = randomViewerForVideo(video);
            try {
                video.getVoteCatalog().newVote(account);
            } catch (Exception ignored) {
            }
        }
    }

}
