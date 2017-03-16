
package com.shakti.presentation.appviewpresenter.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProvidersModel {

    private String _1;
    private String _2;
    private String _3;
    private String _4;

    /**
     * No args constructor for use in serialization
     */
    public ProvidersModel() {
    }


    public ProvidersModel(String _1, String _2, String _3, String _4) {
        super();
        this._1 = _1;
        this._2 = _2;
        this._3 = _3;
        this._4 = _4;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }


}
