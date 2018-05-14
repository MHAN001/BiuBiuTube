package biz.account;

import java.util.ArrayList;

public class Wallet {
    private Account account;
    private int coin;
    private ArrayList<WalletHistory> historyArrayList;

    public Wallet(Account account) {
        this.account = account;
        this.coin = 0;
        this.historyArrayList = new ArrayList<>();
    }

    public ArrayList<WalletHistory> getHistoryArrayList() {
        return historyArrayList;
    }

    public void modifyCoin(int amount) {
        historyArrayList.add(new WalletHistory(amount));
        coin += amount;
    }

    public int getCoin() {
        return coin;
    }
}
