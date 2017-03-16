
package com.shakti.presentation.appviewpresenter.home.model;


public class AppendixModel {


    private AirlinesModel airlinesModel;
    private AirportsModel airportsModel;
    private ProvidersModel providersModel;

    /**
     * No args constructor for use in serialization
     *
     */
    public AppendixModel() {
    }


    public AppendixModel(AirlinesModel airlinesModel, AirportsModel airportsModel, ProvidersModel providersModel) {
        super();
        this.airlinesModel = airlinesModel;
        this.airportsModel = airportsModel;
        this.providersModel = providersModel;
    }

    public AirlinesModel getAirlinesModel() {
        return airlinesModel;
    }

    public void setAirlinesModel(AirlinesModel airlinesModel) {
        this.airlinesModel = airlinesModel;
    }

    public AirportsModel getAirportsModel() {
        return airportsModel;
    }

    public void setAirportsModel(AirportsModel airportsModel) {
        this.airportsModel = airportsModel;
    }

    public ProvidersModel getProvidersModel() {
        return providersModel;
    }

    public void setProvidersModel(ProvidersModel providersModel) {
        this.providersModel = providersModel;
    }



}
