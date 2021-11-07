
package com.trinadh.nutribasket.MVP;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NutriReportResponse {

    private int protin;
    private int vitamin;
    private int fiber;
    private String nutridata;

    public NutriReportResponse (int protin, int vitamin, int fiber){
        this.protin = protin;
        this.vitamin = vitamin;
        this.fiber = fiber;
    }

    public int getProtin(){
        return protin;
    }

    public int getVitamin(){
        return vitamin;
    }

    public int getFiber(){
        return fiber;
    }

    public void setNutridata(String nutridata) {
        this.nutridata = nutridata;
    }
    public String getNutridata() {
        return nutridata;
    }



}