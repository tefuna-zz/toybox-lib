package com.tefuna.toybox.jmareport.report;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDetailRoot {

    private ReportDetailControl control;
    private ReportDetailHead head;

    public ReportDetailControl getControl() {
        return control;
    }

    public void setControl(ReportDetailControl control) {
        this.control = control;
    }

    public ReportDetailHead getHead() {
        return head;
    }

    public void setHead(ReportDetailHead head) {
        this.head = head;
    }

}
