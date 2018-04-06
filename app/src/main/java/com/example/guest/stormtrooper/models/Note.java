package com.example.guest.stormtrooper.models;

/**
 * Created by Guest on 4/3/18.
 */

public class Note {

    private String note;
    private String pushId;
    String index;

    public String getNote() {
        return note;
    }

    public Note(String note){
        this.note = note;
        this.index="not specified";
    }

    public Note(){}

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }



}
