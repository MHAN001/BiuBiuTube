package ui.network.university.college.viewer;

import biz.video.Comment;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class CommentBox extends JPanel {
    private Comment comment;

    public CommentBox(Comment comment) {
        this.comment = comment;
        initComponent();
    }

    private void initComponent() {
        setBackground(Color.white);
        setLayout(new BorderLayout());

        JLabel lblTime = new JLabel(comment.getCalendar().getTime().toString(), JLabel.CENTER);
        add(lblTime, BorderLayout.PAGE_START);

        JTextArea txtComment = new JTextArea(comment.getContent());
        txtComment.setBackground(Color.white);
        txtComment.setEditable(false);
        txtComment.setLineWrap(true);
        EventQueue.invokeLater(() -> add(txtComment));

        TitledBorder border = BorderFactory.createTitledBorder(comment.getAccount().getPerson().getFullName());

        setBorder(border);
    }
}
