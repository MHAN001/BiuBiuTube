package biz.video;

import biz.account.Account;

import java.util.ArrayList;

public class CommentCatalog {
    private Video video;
    private ArrayList<Comment> commentArrayList;

    public ArrayList<Comment> getCommentArrayList() {
        return commentArrayList;
    }

    CommentCatalog(Video video) {
        this.video = video;
        this.commentArrayList = new ArrayList<>();
    }

    public Comment newComment(Account account, String content) {
        Comment c = new Comment(account, content);
        this.commentArrayList.add(c);
        return c;
    }

    void removeComment(Comment c) {
        this.commentArrayList.remove(c);
    }

    public Video getVideo() {
        return video;
    }
}
