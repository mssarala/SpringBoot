package com.sarala.explore.utils.data;

import java.util.ArrayList;
import java.util.List;

public class ReportDataProvider {
    public static List<String> getOverviewHeaders1() {
        List<String> overviewSubHeaders = new ArrayList<>();
        overviewSubHeaders.add("ISIN");
        overviewSubHeaders.add("Category Group WM");
        overviewSubHeaders.add("Category WM");
        overviewSubHeaders.add("Sub-Category WM");
        overviewSubHeaders.add("Subsector WM");
        overviewSubHeaders.add("Approach WM");
        overviewSubHeaders.add("Fund Size (millions)");
        overviewSubHeaders.add("Asset Manager/ Branding Name");
        overviewSubHeaders.add("SRRI");
        overviewSubHeaders.add("WM Reco Universe Status");
        overviewSubHeaders.add("WM Conviction Status");
        overviewSubHeaders.add("SRI Rating WM");
        overviewSubHeaders.add("Legal Structure");
        overviewSubHeaders.add("Countries of Registration");
        overviewSubHeaders.add("Countries Available for sale");
        return overviewSubHeaders;
    }

    public static List<String> getOverviewHeaders2() {
        List<String> overviewSubHeaders = new ArrayList<>();
        overviewSubHeaders.add("Share Categorisation");
        overviewSubHeaders.add("Distribution Status");
        return overviewSubHeaders;
    }

    public static List<String> getManagementHeaders() {
        List<String> managementSubHeaders = new ArrayList<>();
        managementSubHeaders.add("Fund Managers(s)");
        managementSubHeaders.add("Fund Management since");
        managementSubHeaders.add("Inception Date");
        return  managementSubHeaders;
    }

    public static List<String> getFeeHeaders() {
        List<String> feeSubHeaders = new ArrayList<>();
        feeSubHeaders.add("Fee 1");
        feeSubHeaders.add("Fee 2");
        feeSubHeaders.add("Fee 3");
        feeSubHeaders.add("Fee 4");
        feeSubHeaders.add("Fee 5");
        feeSubHeaders.add("Fee 6");
        return  feeSubHeaders;
    }
}
