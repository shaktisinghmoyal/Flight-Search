package com.shakti.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.shakti.data.entity.FlightsEntity;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import javax.inject.Inject;

public class JsonToEntityMapper {

    private final Gson gson;

    @Inject
    public JsonToEntityMapper() {
        this.gson = new Gson();
    }


    /**
     * Transform from valid json string to {@link FlightsEntity}.
     *
     * @param flightsJsonResponse A json representing a user profile.
     * @return {@link FlightsEntity}.
     * @throws com.google.gson.JsonSyntaxException if the json string is not a valid json structure.
     */
    public FlightsEntity transformFlightsEntity(String flightsJsonResponse) throws
            JsonSyntaxException {
        final Type flightsEntityType = new TypeToken<FlightsEntity>() {}.getType();
        return this.gson.fromJson(flightsJsonResponse, flightsEntityType);
    }
}
