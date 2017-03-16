
package com.shakti.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Fare {

    @SerializedName("providerId")
    @Expose
    private Long providerId;
    @SerializedName("fare")
    @Expose
    private Long fare;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fare() {
    }

    /**
     * 
     * @param fare
     * @param providerId
     */
    public Fare(long providerId, long fare) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FareModel {\n");

        sb.append("  providerId: ").append(providerId).append("\n");
        sb.append("  fare: ").append(fare).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (providerId == null ? 0 : providerId.hashCode());
        result = 31 * result + (fare == null ? 0 : fare.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fare) == false) {
            return false;
        }
        Fare rhs = ((Fare) other);
        return (providerId == null ? rhs.providerId == null : providerId.equals(rhs.providerId)) &&
                (fare == null ? rhs.fare == null : fare.equals(rhs.fare));
    }

}
