package com.tefuna.toybox.jmareport.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDetailHead {

    private String title;
    private String reportDateTime;
    private String targetDateTime;
    private String eventID;
    private String infoType;
    private String serial;
    private String infoKind;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReportDateTime() {
        return reportDateTime;
    }

    public void setReportDateTime(String reportDateTime) {
        this.reportDateTime = reportDateTime;
    }

    public String getTargetDateTime() {
        return targetDateTime;
    }

    public void setTargetDateTime(String targetDateTime) {
        this.targetDateTime = targetDateTime;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getInfoKind() {
        return infoKind;
    }

    public void setInfoKind(String infoKind) {
        this.infoKind = infoKind;
    }

    public String getInfoKindVersion() {
        return infoKindVersion;
    }

    public void setInfoKindVersion(String infoKindVersion) {
        this.infoKindVersion = infoKindVersion;
    }

    private String infoKindVersion;

    // TODO private Headline headline;

}
