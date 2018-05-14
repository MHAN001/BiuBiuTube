package biz.video;

import biz.account.Account;

import java.util.ArrayList;

public class VoteCatalog {
    private Video video;
    private ArrayList<Vote> voteArrayList;

    public Vote newVote(Account account) throws Exception {
        if (voteArrayList.stream().anyMatch(v -> v.getAccount().equals(account))) {
            throw new Exception("Already voted");
        }

        Vote v = new Vote(this.video, account);
        this.voteArrayList.add(v);
        return v;
    }

    public Video getVideo() {
        return video;
    }

    public ArrayList<Vote> getVoteArrayList() {
        return voteArrayList;
    }

    VoteCatalog(Video video) {
        this.video = video;
        this.voteArrayList = new ArrayList<>();
    }
}
