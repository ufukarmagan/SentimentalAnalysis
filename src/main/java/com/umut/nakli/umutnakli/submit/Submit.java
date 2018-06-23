package com.umut.nakli.umutnakli.submit;


import java.util.Map;

public class Submit {
    String id;
    String text;
    String userName;
    

    public String getText() {
        return text;
    }

    public Submit setText(String text) {
        this.text = text;
        return this;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public Submit setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}