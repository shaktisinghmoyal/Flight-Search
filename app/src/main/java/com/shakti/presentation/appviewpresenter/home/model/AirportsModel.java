
package com.shakti.presentation.appviewpresenter.home.model;


public class AirportsModel {

    private String dEL;
    private String bOM;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AirportsModel() {
    }

    public AirportsModel(String dEL, String bOM) {
        super();
        this.dEL = dEL;
        this.bOM = bOM;
    }

    public String getDEL() {
        return dEL;
    }

    public void setDEL(String dEL) {
        this.dEL = dEL;
    }

    public String getBOM() {
        return bOM;
    }

    public void setBOM(String bOM) {
        this.bOM = bOM;
    }


}
