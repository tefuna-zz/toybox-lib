package com.tefuna.toybox.jmareport.report;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportHeaderList {

    private List<ReportHeader> data = new ArrayList<ReportHeader>();

    public void setData(List data) {
        this.data = data;
    }

    public List getData() {
        return this.data;
    }

}
