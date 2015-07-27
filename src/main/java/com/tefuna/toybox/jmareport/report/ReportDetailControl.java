package com.tefuna.toybox.jmareport.report;

import java.util.List;

public class ReportDetailControl {

    private String title;
    private String dateTime;
    private String status;
    private String editorialOffice;
    private List<String> publishingOffice;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEditorialOffice() {
        return editorialOffice;
    }

    public void setEditorialOffice(String editorialOffice) {
        this.editorialOffice = editorialOffice;
    }

    public List<String> getPublishingOffice() {
        return this.publishingOffice;
    }

    public void setPublishingOffice(List<String> publishingOffice) {
        this.publishingOffice = publishingOffice;
    }

}
