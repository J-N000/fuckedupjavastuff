package com.zipline.demo.models;

//TODO: WORK IN PROGRESS.

import java.util.ArrayList;
import java.util.HashMap;

public class Account {
    private final String ACCOUNT_ID = "";
    private String githubId;
    private ArrayList<String> wallets = new ArrayList<>();
    private HashMap<String, String> subscriptions;
    private HashMap<String, Message> posts;

    public Account(String githubId, String walletHash) {
        this.githubId = githubId;
        addWallet(walletHash);
    }

    public void addWallet(String walletHash) {
        this.wallets.add(walletHash);
    }

    public void addSubscription(String githubId, String subHash) {
        this.subscriptions.put(githubId, subHash);
    }

    public void addPost(Message post) {

    }

}
