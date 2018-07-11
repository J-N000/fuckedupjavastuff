package com.zipline.demo.models;

public class Nested {

    Message body;

    public Message getBody() {
        return body;
    }

    public void setBody(Message body) {
        this.body = body;
    }

    public Nested(Message body) {

        this.body = body;
    }
}
