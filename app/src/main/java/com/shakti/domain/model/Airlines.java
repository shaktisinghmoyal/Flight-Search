
package com.shakti.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Airlines {

    @SerializedName("SG")
    @Expose
    private String sG;
    @SerializedName("AI")
    @Expose
    private String aI;
    @SerializedName("G8")
    @Expose
    private String g8;
    @SerializedName("9W")
    @Expose
    private String _9W;
    @SerializedName("6E")
    @Expose
    private String _6E;

    /**
     * No args constructor for use in serialization
     */
    public Airlines() {
    }

    /**
     * @param _9W
     * @param aI
     * @param g8
     * @param _6E
     * @param sG
     */
    public Airlines(String sG, String aI, String g8, String _9W, String _6E) {
        super();
        this.sG = sG;
        this.aI = aI;
        this.g8 = g8;
        this._9W = _9W;
        this._6E = _6E;
    }

    public String getSG() {
        return sG;
    }

    public void setSG(String sG) {
        this.sG = sG;
    }

    public String getAI() {
        return aI;
    }

    public void setAI(String aI) {
        this.aI = aI;
    }

    public String getG8() {
        return g8;
    }

    public void setG8(String g8) {
        this.g8 = g8;
    }

    public String get9W() {
        return _9W;
    }

    public void set9W(String _9W) {
        this._9W = _9W;
    }

    public String get6E() {
        return _6E;
    }

    public void set6E(String _6E) {
        this._6E = _6E;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Airlines {\n");

        sb.append("  sG: ").append(sG).append("\n");
        sb.append("  aI: ").append(aI).append("\n");
        sb.append("  g8: ").append(g8).append("\n");
        sb.append("  _9W: ").append(_9W).append("\n");
        sb.append("  _6E: ").append(_6E).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (sG == null ? 0 : sG.hashCode());
        result = 31 * result + (aI == null ? 0 : aI.hashCode());
        result = 31 * result + (g8 == null ? 0 : g8.hashCode());
        result = 31 * result + (_9W == null ? 0 : _9W.hashCode());
        result = 31 * result + (_6E == null ? 0 : _6E.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Airlines) == false) {
            return false;
        }
        Airlines rhs = ((Airlines) other);
        return (sG == null ? rhs.sG == null : sG.equals(rhs.sG)) &&
                (aI == null ? rhs.aI == null : aI.equals(rhs.aI)) &&
                (g8 == null ? rhs.g8 == null : g8.equals(rhs.g8)) &&
                (_9W == null ? rhs._9W == null : _9W.equals(rhs._9W)) &&
                (_6E == null ? rhs._6E == null : _6E.equals(rhs._6E));
    }

}
