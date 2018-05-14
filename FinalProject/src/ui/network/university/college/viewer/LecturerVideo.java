package ui.network.university.college.viewer;

import biz.account.Account;
import biz.person.Person;
import biz.video.Video;
import ui.components.ChildComponent;
import ui.components.HasTitle;
import ui.components.ParentUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static hlp.ComponentHelper.setComponentSize;

public class LecturerVideo extends JPanel implements ChildComponent, HasTitle {
    private Account account;
    private Person lecturer;
    private ParentUI parent;
    private JPanel rightContainer;

    public LecturerVideo(ParentUI parent, Person lecturer, Account account) {
        this.account = account;
        this.parent = parent;
        this.lecturer = lecturer;
        initComponents();
        populateVideoList();
    }

    private Stream<Video> getLecturerVideoStream() {
        return lecturer
                .getOrg()
                .getEnterprise()
                .getNetwork()
                .getVideoCatalog()
                .getVideoArrayList()
                .stream()
                .filter(video -> video.getUploaderAccount().getPerson().equals(lecturer))
                .filter(Video::canView);
    }

    public void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JSplitPane splitPane = new JSplitPane();
        add(splitPane);
        splitPane.setDividerLocation(200);
        splitPane.setEnabled(false);

        // left pane
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        splitPane.setLeftComponent(leftPanel);

        // avatar
        try {
            URL url = new URL(lecturer.getAvatarPath());
            BufferedImage image = ImageIO.read(url);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            setComponentSize(picLabel, 200, 200);
            leftPanel.add(picLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // stat
        long totalVideos = getLecturerVideoStream().count();
        leftPanel.add(new JLabel(String.format("Total Videos: %d", totalVideos)));

        long totalViews = getLecturerVideoStream()
                .map(video -> video.getViewHistoryCatalog().getViewHistoryArrayList().size())
                .reduce(0, Integer::sum);
        leftPanel.add(new JLabel(String.format("Total/Avg Views: %d/%.2f", totalViews, ((double) totalViews) / totalVideos)));

        long totalVotes = getLecturerVideoStream()
                .map(video -> video.getVoteCatalog().getVoteArrayList().size())
                .reduce(0, Integer::sum);
        leftPanel.add(new JLabel(String.format("Total/Avg Votes: %d/%.2f", totalVotes, ((double) totalVotes) / totalVideos)));

        long totalComments = getLecturerVideoStream()
                .map(video -> video.getCommentCatalog().getCommentArrayList().size())
                .reduce(0, Integer::sum);
        leftPanel.add(new JLabel(String.format("Total/Avg Comments: %d/%.2f", totalComments, ((double) totalComments) / totalVideos)));

        // right
        rightContainer = new JPanel();
        rightContainer.setLayout(new BoxLayout(rightContainer, BoxLayout.Y_AXIS));
        rightContainer.setBackground(new Color(153, 153, 153));
        JScrollPane scrollPane = new JScrollPane(rightContainer);
        splitPane.setRightComponent(scrollPane);
    }


    private void populateVideoList() {
        rightContainer.removeAll();

        getLecturerVideoStream().forEach(video -> {
            rightContainer.add(new VideoBox(parent, video, account));
            rightContainer.add(Box.createRigidArea(new Dimension(0, 10)));
        });

        revalidate();
        repaint();
    }

    @Override
    public void exposed() {
        populateVideoList();
    }

    @Override
    public String getTitle() {
        return String.format("%s's Videos", lecturer);
    }
}
