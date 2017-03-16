
package com.shakti.presentation.appviewpresenter.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class FareModel {

    private Long providerId;
    private Long fare;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FareModel() {
    }

    public FareModel(long providerId, long fare) {
        super();
        this.providerId = providerId;
        this.fare = fare;
    }

    public long getProviderId() {
        return providerId;
    }

    public void setProviderId(long providerId) {
        this.providerId = providerId;
    }

    public long getFare() {
        return fare;
    }

    public void setFare(long fare) {
        this.fare = fare;
    }



}
