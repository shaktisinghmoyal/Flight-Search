
package com.shakti.presentation.appviewpresenter.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class FlightModel {

    private String originCode;
    private String destinationCode;
    private Long departureTime;
    private Long arrivalTime;
    private List<FareModel> fareModels = null;
    private String airlineCode;
    private String _class;

    /**
     * No args constructor for use in serialization
     */
    public FlightModel() {
    }


    public FlightModel(String originCode, String destinationCode, long departureTime, long arrivalTime, List<FareModel> fareModels, String airlineCode, String _class) {
        super();
        this.originCode = originCode;
        this.destinationCode = destinationCode;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fareModels = fareModels;
        this.airlineCode = airlineCode;
        this._class = _class;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public long getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(long departureTime) {
        this.departureTime = departureTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<FareModel> getFareModels() {
        return fareModels;
    }

    public void setFareModels(List<FareModel> fareModels) {
        this.fareModels = fareModels;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }


}
