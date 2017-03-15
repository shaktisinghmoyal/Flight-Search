
package com.shakti.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airports {

    @SerializedName("DEL")
    @Expose
    private String dEL;
    @SerializedName("BOM")
    @Expose
    private String bOM;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Airports() {
    }

    /**
     * 
     * @param dEL
     * @param bOM
     */
    public Airports(String dEL, String bOM) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Airports {\n");

        sb.append("  dEL: ").append(dEL).append("\n");
        sb.append("  bOM: ").append(bOM).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (dEL == null ? 0 : dEL.hashCode());
        result = 31 * result + (bOM == null ? 0 : bOM.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Airports) == false) {
            return false;
        }
        Airports rhs = ((Airports) other);
        return (dEL == null ? rhs.dEL == null : dEL.equals(rhs.dEL)) &&
                (bOM == null ? rhs.bOM == null : bOM.equals(rhs.bOM));
    }

}
