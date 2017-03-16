
package com.shakti.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Appendix {

    @SerializedName("airlines")
    @Expose

    private Airlines airlines;
    @SerializedName("airports")
    @Expose

    private Airports airports;
    @SerializedName("providers")
    @Expose

    private Providers providers;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Appendix() {
    }

    /**
     * 
     * @param providers
     * @param airports
     * @param airlines
     */
    public Appendix(Airlines airlines, Airports airports, Providers providers) {
        super();
        this.airlines = airlines;
        this.airports = airports;
        this.providers = providers;
    }

    public Airlines getAirlines() {
        return airlines;
    }

    public void setAirlines(Airlines airlines) {
        this.airlines = airlines;
    }

    public Airports getAirports() {
        return airports;
    }

    public void setAirports(Airports airports) {
        this.airports = airports;
    }

    public Providers getProviders() {
        return providers;
    }

    public void setProviders(Providers providers) {
        this.providers = providers;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppendixModel {\n");

        sb.append("  airlines: ").append(airlines).append("\n");
        sb.append("  airports: ").append(airports).append("\n");
        sb.append("  providers: ").append(providers).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (airlines == null ? 0 : airlines.hashCode());
        result = 31 * result + (airports == null ? 0 : airports.hashCode());
        result = 31 * result + (providers == null ? 0 : providers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Appendix) == false) {
            return false;
        }
        Appendix rhs = ((Appendix) other);
        return (airlines == null ? rhs.airlines == null : airlines.equals(rhs.airlines)) &&
                (airports == null ? rhs.airports == null : airports.equals(rhs.airports)) &&
                (providers == null ? rhs.providers == null : providers.equals(rhs.providers));
    }

}
