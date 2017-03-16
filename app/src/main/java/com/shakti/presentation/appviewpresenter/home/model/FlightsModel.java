
package com.shakti.presentation.appviewpresenter.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightsModel {

    private AppendixModel appendixModel;
    private List<FlightModel> flightModels = null;

    /**
     * No args constructor for use in serialization
     */
    public FlightsModel() {
    }


    public FlightsModel(AppendixModel appendixModel, List<FlightModel> flightModels) {
        super();
        this.appendixModel = appendixModel;
        this.flightModels = flightModels;
    }

    public AppendixModel getAppendixModel() {
        return appendixModel;
    }

    public void setAppendixModel(AppendixModel appendixModel) {
        this.appendixModel = appendixModel;
    }

    public List<FlightModel> getFlightModels() {
        return flightModels;
    }

    public void setFlightModels(List<FlightModel> flightModels) {
        this.flightModels = flightModels;
    }



}
