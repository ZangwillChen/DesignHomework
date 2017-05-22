package com.czw.entity;

/**
 * Created by chenzhaowen on 2017/5/22.
 */
public class Announcement {

    private long annoID;
    private String annoTitle;
    private String annoContent;
    private String annoPerson;
    private String annoTime;

    public Announcement(){

    }

    public Announcement(long annoID,String annoTitle, String annoContent,
                        String annoPerson, String annoTime){
        this.annoID = annoID;
        this.annoTitle = annoTitle;
        this.annoContent = annoContent;
        this.annoPerson = annoPerson;
        this.annoTime = annoTime;
    }

    public long getAnnoID() {
        return annoID;
    }

    public void setAnnoID(long annoID) {
        this.annoID = annoID;
    }

    public String getAnnoTitle() {
        return annoTitle;
    }

    public void setAnnoTitle(String annoTitle) {
        this.annoTitle = annoTitle;
    }

    public String getAnnoContent() {
        return annoContent;
    }

    public void setAnnoContent(String annoContent) {
        this.annoContent = annoContent;
    }

    public String getAnnoPerson() {
        return annoPerson;
    }

    public void setAnnoPerson(String annoPerson) {
        this.annoPerson = annoPerson;
    }

    public String getAnnoTime() {
        return annoTime;
    }

    public void setAnnoTime(String annoTime) {
        this.annoTime = annoTime;
    }
}
