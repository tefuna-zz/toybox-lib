package com.tefuna.toybox.jmareport;

import org.springframework.web.client.RestTemplate;

import com.tefuna.toybox.jmareport.report.ReportDetail;
import com.tefuna.toybox.jmareport.report.ReportHeaderList;

/**
 * 
 * @author tefuna
 *
 */
public class Main {

    private static final String URL_JMA_HEADER = "http://api.aitc.jp/jmardb-api/search";
    private static final String URL_JMA_DETAIL = "http://api.aitc.jp/jmardb-api/search";

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();
        ReportHeaderList data = restTemplate.getForObject(URL_JMA_HEADER + "?datetime=2013-01-01&datetime=2013-02-01",
                ReportHeaderList.class);
        System.out.println(data);

        ReportDetail detail = restTemplate.getForObject(
                "http://api.aitc.jp/jmardb-api/reports/c811971d-75d3-4a83-9bd7-3ec287ad7e2e.json", ReportDetail.class);
        System.out.println(detail);

        return;

    }

}
