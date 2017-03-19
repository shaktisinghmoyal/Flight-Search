
package com.shakti.presentation.mapper;


import com.shakti.domain.model.Flights;
import com.shakti.presentation.appviewpresenter.home.model.FlightsModel;
import com.shakti.presentation.di.PerActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;

/**
 * Mapper class used to transform Book (in the domain layer) to { BookModel} in the
 * presentation layer.
 */
@PerActivity
public class DataMapper {


    private final String Tag = "BookModelDataMapper";
    @Inject
    public DataMapper() {
    }
    public FlightsModel transform(Flights flights) {
        FlightsModel flightsModel = null;
        if (flights == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }

        return flightsModel;
    }

    public Flights transform(FlightsModel flightsModel) {
        Flights flights = null;
        if (flightsModel != null) {

        }

        return flights;
    }

}
