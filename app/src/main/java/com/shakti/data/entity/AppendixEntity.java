
package com.shakti.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppendixEntity {

    @SerializedName("airlines")
    @Expose

    private AirlinesEntity airlinesEntity;
    @SerializedName("airports")
    @Expose

    private AirportsEntity airportsEntity;
    @SerializedName("providers")
    @Expose

    private ProvidersEntity providersEntity;

    /**
     * No args constructor for use in serialization
     *
     */
    public AppendixEntity() {
    }

    /**
     *
     * @param providersEntity
     * @param airportsEntity
     * @param airlinesEntity
     */
    public AppendixEntity(AirlinesEntity airlinesEntity, AirportsEntity airportsEntity, ProvidersEntity providersEntity) {
        super();
        this.airlinesEntity = airlinesEntity;
        this.airportsEntity = airportsEntity;
        this.providersEntity = providersEntity;
    }

    public AirlinesEntity getAirlinesEntity() {
        return airlinesEntity;
    }

    public void setAirlinesEntity(AirlinesEntity airlinesEntity) {
        this.airlinesEntity = airlinesEntity;
    }

    public AirportsEntity getAirportsEntity() {
        return airportsEntity;
    }

    public void setAirportsEntity(AirportsEntity airportsEntity) {
        this.airportsEntity = airportsEntity;
    }

    public ProvidersEntity getProvidersEntity() {
        return providersEntity;
    }

    public void setProvidersEntity(ProvidersEntity providersEntity) {
        this.providersEntity = providersEntity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AppendixModel {\n");

        sb.append("  airlinesEntity: ").append(airlinesEntity).append("\n");
        sb.append("  airportsEntity: ").append(airportsEntity).append("\n");
        sb.append("  providersEntity: ").append(providersEntity).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (airlinesEntity == null ? 0 : airlinesEntity.hashCode());
        result = 31 * result + (airportsEntity == null ? 0 : airportsEntity.hashCode());
        result = 31 * result + (providersEntity == null ? 0 : providersEntity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AppendixEntity) == false) {
            return false;
        }
        AppendixEntity rhs = ((AppendixEntity) other);
        return (airlinesEntity == null ? rhs.airlinesEntity == null : airlinesEntity.equals(rhs.airlinesEntity)) &&
                (airportsEntity == null ? rhs.airportsEntity == null : airportsEntity.equals(rhs.airportsEntity)) &&
                (providersEntity == null ? rhs.providersEntity == null : providersEntity.equals(rhs.providersEntity));
    }

}
