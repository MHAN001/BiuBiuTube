/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.network.university.college.viewer;

import biz.account.Account;
import biz.video.Video;
import biz.video.VideoTag;
import ui.components.ParentUI;
import ui.my.RedeemJPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static hlp.ComponentHelper.setComponentSize;

/**
 * @author hezj
 */
public class VideoBox extends JPanel {
    private Video video;
    private ParentUI parent;
    private Account account;

    public VideoBox(ParentUI parent, Video video, Account account) {
        this.parent = parent;
        this.account = account;
        this.video = video;
        initComponents();

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                watchListener(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    private void initComponents() {
        setBackground(new Color(204, 204, 204));
        setComponentSize(this, 700, 300);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        try {
            URL url = new URL(video.getPicPath());
            BufferedImage image = ImageIO.read(url);
            JLabel picLabel = new JLabel(new ImageIcon(image));
            setComponentSize(picLabel, 300, 300);
            add(picLabel);
        } catch (Exception ignored) {
        }

        JPanel right = new JPanel();
        setComponentSize(right, 400, 300);
        right.setLayout(new BorderLayout());
        add(right);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        right.add(titlePanel, BorderLayout.PAGE_START);

        String title = video.getTitle();
        JLabel lblTitle = new JLabel(title, JLabel.CENTER);
        Font f = lblTitle.getFont();
        lblTitle.setFont(new Font(f.getName(), f.getStyle(), 22));
        titlePanel.add(lblTitle, BorderLayout.PAGE_START);

        if (video.isPrimeOnly()) {
            JLabel lblSubTitle = new JLabel("(Prime Only)", JLabel.CENTER);
            titlePanel.add(lblSubTitle, BorderLayout.PAGE_END);
        }

        JPanel rightMiddle = new JPanel();
        rightMiddle.setLayout(new BorderLayout());

        JTextArea txtDesc = new JTextArea(video.getDescription());
        txtDesc.setLineWrap(true);
        txtDesc.setEditable(false);
        EventQueue.invokeLater(() -> rightMiddle.add(txtDesc));

        JPanel rightFooter = new JPanel();
        rightFooter.setLayout(new BorderLayout());

        JPanel rightFooterTags = new JPanel();
        rightFooterTags.setLayout(new BoxLayout(rightFooterTags, BoxLayout.X_AXIS));
        for (VideoTag tag : video.getTagHashSet()) {
            JLabel tagLabel = new JLabel(tag.getName());
            tagLabel.setBackground(new Color(153, 153, 153));
            tagLabel.setOpaque(true);
            tagLabel.setBorder(new EmptyBorder(0, 2, 0, 2));
            rightFooterTags.add(tagLabel);
            rightFooterTags.add(Box.createRigidArea(new Dimension(5, 0)));
        }
        rightFooter.add(rightFooterTags, BorderLayout.PAGE_START);

        JPanel rightFooterStat = new JPanel();
        rightFooterStat.setLayout(new BoxLayout(rightFooterStat, BoxLayout.X_AXIS));
        rightFooterStat.add(new JLabel(String.format("Lecturer: %s", video.getUploaderAccount().getPerson())));
        rightFooterStat.add(Box.createHorizontalGlue());

        rightFooterStat.add(new JLabel(String.format("Views: %d", video.getViewHistoryCatalog().getViewHistoryArrayList().size())));
        rightFooterStat.add(Box.createRigidArea(new Dimension(5, 0)));
        rightFooterStat.add(new JLabel(String.format("Up Votes: %d", video.getVoteCatalog().getVoteArrayList().size())));
        rightFooter.add(rightFooterStat, BorderLayout.PAGE_END);

        rightMiddle.add(rightFooter, BorderLayout.PAGE_END);
        right.add(rightMiddle);



        JButton btnWatch = new JButton("Watch >>");
        btnWatch.addActionListener(this::watchListener);
        right.add(btnWatch, BorderLayout.PAGE_END);
    }


    private void watchListener(AWTEvent e) {
        if (video.isPrimeOnly() && account.getPrimeMembership().isExpired()) {
            int res = JOptionPane.showConfirmDialog(
                    this,
                    "Only Prime member can view this video, Redeem?",
                    "Error",
                    JOptionPane.YES_NO_OPTION
            );
            if (res == JOptionPane.YES_OPTION) {
                parent.pushComponent(new RedeemJPanel(parent, account));
            }
            return;
        }
        parent.pushComponent(new ViewVideo(parent, video, account));
    }

}
