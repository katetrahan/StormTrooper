package com.example.guest.stormtrooper.models;

/**
 * Created by Guest on 4/3/18.
 */

public class Note {

    private String note;
    private String pushId;

    public String getNote() {
        return note;
    }

    public Note(String note){
        this.note = note;
    }

    public Note(){}

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }



}
