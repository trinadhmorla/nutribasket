package com.trinadh.nutribasket.MVP;

import java.util.List;

public class NutriReportResponce {

    private String success;

    private List<NutriReportResponse> nutridata = null;

    public List<NutriReportResponse> getNutridata() {
        return nutridata;
    }

    public String getSuccess() {
        return success;
    }

}