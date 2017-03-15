
package com.shakti.domain.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Flight {

    @SerializedName("originCode")
    @Expose
    private String originCode;
    @SerializedName("destinationCode")
    @Expose
    private String destinationCode;
    @SerializedName("departureTime")
    @Expose
    private Long departureTime;
    @SerializedName("arrivalTime")
    @Expose
    private Long arrivalTime;
    @SerializedName("fares")
    @Expose
    private List<Fare> fares = null;
    @SerializedName("airlineCode")
    @Expose
    private String airlineCode;
    @SerializedName("class")
    @Expose
    private String _class;

    /**
     * No args constructor for use in serialization
     */
    public Flight() {
    }

    /**
     * @param fares
     * @param destinationCode
     * @param _class
     * @param airlineCode
     * @param arrivalTime
     * @param departureTime
     * @param originCode
     */
    public Flight(String originCode, String destinationCode, long departureTime, long arrivalTime, List<Fare> fares, String airlineCode, String _class) {
        super();
        this.originCode = originCode;
        this.destinationCode = destinationCode;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fares = fares;
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

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Flight {\n");

        sb.append("  originCode: ").append(originCode).append("\n");
        sb.append("  destinationCode: ").append(destinationCode).append("\n");
        sb.append("  departureTime: ").append(departureTime).append("\n");
        sb.append("  arrivalTime: ").append(arrivalTime).append("\n");
        sb.append("  fares: ").append(fares).append("\n");
        sb.append("  airlineCode: ").append(airlineCode).append("\n");
        sb.append("  _class: ").append(_class).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (originCode == null ? 0 : originCode.hashCode());
        result = 31 * result + (destinationCode == null ? 0 : destinationCode.hashCode());
        result = 31 * result + (departureTime == null ? 0 : departureTime.hashCode());
        result = 31 * result + (arrivalTime == null ? 0 : arrivalTime.hashCode());
        result = 31 * result + (fares == null ? 0 : fares.hashCode());
        result = 31 * result + (airlineCode == null ? 0 : airlineCode.hashCode());
        result = 31 * result + (_class == null ? 0 : _class.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Flight) == false) {
            return false;
        }
        Flight rhs = ((Flight) other);
        return (originCode == null ? rhs.originCode == null : originCode.equals(rhs.originCode)) &&
                (destinationCode == null ? rhs.destinationCode == null : destinationCode.equals
                        (rhs.destinationCode)) &&
                (departureTime == null ? rhs.departureTime == null : departureTime.equals(rhs.departureTime)) &&
                (arrivalTime == null ? rhs.arrivalTime == null : arrivalTime.equals(rhs.arrivalTime)) &&
                (fares == null ? rhs.fares == null : fares.equals(rhs.fares)) &&
                (airlineCode == null ? rhs.airlineCode == null : airlineCode.equals(rhs.airlineCode)) &&
                (_class == null ? rhs._class == null : _class.equals(rhs._class));
    }

}
