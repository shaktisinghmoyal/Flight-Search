
package com.shakti.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProvidersEntity {

    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("2")
    @Expose
    private String _2;
    @SerializedName("3")
    @Expose
    private String _3;
    @SerializedName("4")
    @Expose
    private String _4;

    /**
     * No args constructor for use in serialization
     */
    public ProvidersEntity() {
    }

    /**
     * @param _3
     * @param _4
     * @param _1
     * @param _2
     */
    public ProvidersEntity(String _1, String _2, String _3, String _4) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProvidersModel {\n");

        sb.append("  _1: ").append(_1).append("\n");
        sb.append("  _2: ").append(_2).append("\n");
        sb.append("  _3: ").append(_3).append("\n");
        sb.append("  _4: ").append(_4).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (_1 == null ? 0 : _1.hashCode());
        result = 31 * result + (_2 == null ? 0 : _2.hashCode());
        result = 31 * result + (_3 == null ? 0 : _3.hashCode());
        result = 31 * result + (_4 == null ? 0 : _4.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProvidersEntity) == false) {
            return false;
        }
        ProvidersEntity rhs = ((ProvidersEntity) other);
        return (_1 == null ? rhs._1 == null : _1.equals(rhs._1)) &&
                (_2 == null ? rhs._2 == null : _2.equals(rhs._2)) &&
                (_3 == null ? rhs._3 == null : _3.equals(rhs._3)) &&
                (_4 == null ? rhs._4 == null : _4.equals(rhs._4));
    }

}
