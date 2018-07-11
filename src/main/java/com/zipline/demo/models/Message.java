package com.zipline.demo.models;

import java.util.ArrayList;

public class Message implements Content {
    private String sender;
    private String receiver;
    private String messageBody;
    private String timestamp;
    private ArrayList<String> pointers = new ArrayList<>();

    public Message(String sender, String receiver, String messageBody, String timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageBody = messageBody;
        this.timestamp = timestamp;
    }

    public Message(String sender, String messageBody, String timestamp) {
        this.sender = sender;
        this.messageBody = messageBody;
        this.timestamp = timestamp;
    }

    public Message(ArrayList<String> pointers, String sender, String messageBody, String timestamp) {
        this.pointers = pointers;
        this.sender = sender;
        this.messageBody = messageBody;
        this.timestamp = timestamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public void setBody(String messageBody) { this.messageBody = messageBody; }

    public String getTimestamp() { return timestamp; }

    public void addPointer(String hash) {
        pointers.add(hash);
    }
}
