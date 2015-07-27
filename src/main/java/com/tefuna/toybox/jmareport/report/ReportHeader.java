package com.tefuna.toybox.jmareport.report;

import java.util.List;

public class ReportHeader {

    private String datatime;
    private List<String> headline;
    private String link;
    private String title;

    public String getDatatime() {
        return datatime;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public List<String> getHeadline() {
        return headline;
    }

    public void setHeadline(List<String> headline) {
        this.headline = headline;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
