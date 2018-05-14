package hlp.fkr;

import biz.account.Account;
import biz.nw.Network;
import biz.org.unv.UniverseCollegeOrganization;
import biz.video.Report;
import biz.video.Video;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ReportHelper {
    public static Faker faker = new Faker();

    private static Stream<Video> getCollegeVideos(Network network, UniverseCollegeOrganization college) {
        return network.getVideoCatalog().getVideoArrayList().stream()
                .filter(v -> v.getUploaderAccount().getOrg().equals(college));
    }


    public static void fakeReports(UniverseCollegeOrganization college, int totalCount) {
        Network network = college.getEnterprise().getNetwork();

        do {
            Stream<Video> stream = getCollegeVideos(network, college);
            int total = (int) getCollegeVideos(network, college).count();
            if (total > 0 && faker.random().nextInt(10) > 0) {  // 90% change fake report on video already have reports
                int hasReport = (int)  getCollegeVideos(network, college).filter(v -> v.getReportCatalog().getReportArrayList().size() > 0).count();
                if (hasReport > 0) {
                    stream = getCollegeVideos(network, college).filter(v -> v.getReportCatalog().getReportArrayList().size() > 0);
                    total = hasReport;
                }
            }
            int skip = total > 0 ? faker.random().nextInt(total) : 0;
            Video video = stream.skip(skip).findFirst().orElse(null);
            fakeReport(video);
        } while (totalCount-- > 0);

    }

    public static Report fakeReport(Video video) {
        Network network = video.getUploaderAccount().getOrg().getEnterprise().getNetwork();
        ArrayList<UniverseCollegeOrganization> collegeArrayList = network.getUniversity().getCollegeCatalog().getOrganizations();
        UniverseCollegeOrganization college = collegeArrayList.stream().skip(faker.random().nextInt(collegeArrayList.size())).findFirst().orElse(null);
        if (college == null) {
            return null;
        }

        ArrayList<Account> viewerArrayList = college.getAccountCatalog().getAccountArrayList();
        Account viewer = viewerArrayList.stream().skip(faker.random().nextInt(viewerArrayList.size())).findFirst().orElse(null);
        if (viewer == null) {
            return null;
        }
        return video.getReportCatalog().newReport(viewer, faker.shakespeare().kingRichardIIIQuote());
    }
}
