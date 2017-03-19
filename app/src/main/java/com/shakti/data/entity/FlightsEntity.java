
package com.shakti.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlightsEntity {

    @SerializedName("appendix")
    @Expose
    private AppendixEntity appendixEntity;
    @SerializedName("flights")
    @Expose
    private List<FlightEntity> flightEntities = null;

    /**
     * No args constructor for use in serialization
     */
    public FlightsEntity() {
    }

    /**
     * @param flightEntities
     * @param appendixEntity
     */
    public FlightsEntity(AppendixEntity appendixEntity, List<FlightEntity> flightEntities) {
        super();
        this.appendixEntity = appendixEntity;
        this.flightEntities = flightEntities;
    }

    public AppendixEntity getAppendixEntity() {
        return appendixEntity;
    }

    public void setAppendixEntity(AppendixEntity appendixEntity) {
        this.appendixEntity = appendixEntity;
    }

    public List<FlightEntity> getFlightEntities() {
        return flightEntities;
    }

    public void setFlightEntities(List<FlightEntity> flightEntities) {
        this.flightEntities = flightEntities;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FlightsModel {\n");

        sb.append("  appendixEntity: ").append(appendixEntity).append("\n");
        sb.append("  flightEntities: ").append(flightEntities).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (appendixEntity == null ? 0 : appendixEntity.hashCode());
        result = 31 * result + (flightEntities == null ? 0 : flightEntities.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlightsEntity) == false) {
            return false;
        }
        FlightsEntity rhs = ((FlightsEntity) other);
        return (flightEntities == null ? rhs.flightEntities == null : flightEntities.equals(rhs.flightEntities)) &&
                (flightEntities == null ? rhs.flightEntities == null : flightEntities.equals(rhs.flightEntities));
    }

}
