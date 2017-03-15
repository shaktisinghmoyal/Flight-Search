
package com.shakti.domain.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flights {

    @SerializedName("appendix")
    @Expose
    private Appendix appendix;
    @SerializedName("flights")
    @Expose
    private List<Flight> flights = null;

    /**
     * No args constructor for use in serialization
     */
    public Flights() {
    }

    /**
     * @param flights
     * @param appendix
     */
    public Flights(Appendix appendix, List<Flight> flights) {
        super();
        this.appendix = appendix;
        this.flights = flights;
    }

    public Appendix getAppendix() {
        return appendix;
    }

    public void setAppendix(Appendix appendix) {
        this.appendix = appendix;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Flights {\n");

        sb.append("  appendix: ").append(appendix).append("\n");
        sb.append("  flights: ").append(flights).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (appendix == null ? 0 : appendix.hashCode());
        result = 31 * result + (flights == null ? 0 : flights.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Flights) == false) {
            return false;
        }
        Flights rhs = ((Flights) other);
        return (flights == null ? rhs.flights == null : flights.equals(rhs.flights)) &&
                (flights == null ? rhs.flights == null : flights.equals(rhs.flights));
    }

}
