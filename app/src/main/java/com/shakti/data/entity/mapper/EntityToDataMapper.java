package com.shakti.data.entity.mapper;

import com.shakti.data.entity.FareEntity;
import com.shakti.data.entity.FlightEntity;
import com.shakti.data.entity.FlightsEntity;
import com.shakti.domain.model.Airlines;
import com.shakti.domain.model.Airports;
import com.shakti.domain.model.Appendix;
import com.shakti.domain.model.Fare;
import com.shakti.domain.model.Flight;
import com.shakti.domain.model.Flights;
import com.shakti.domain.model.Providers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class EntityToDataMapper {

    @Inject
    public EntityToDataMapper() {
    }


    public Flights transformFromFlightsEntity(FlightsEntity flightsEntity) {

        Flights flights = new Flights();
        if (flightsEntity != null) {
            Airlines airlines = new Airlines();
            airlines.set6E(flightsEntity.getAppendixEntity().getAirlinesEntity().get6E());
            airlines.set9W(flightsEntity.getAppendixEntity().getAirlinesEntity().get9W());
            airlines.setAI(flightsEntity.getAppendixEntity().getAirlinesEntity().getAI());
            airlines.setG8(flightsEntity.getAppendixEntity().getAirlinesEntity().getG8());
            airlines.setSG(flightsEntity.getAppendixEntity().getAirlinesEntity().getG8());

            Airports airports = new Airports();
            airports.setBOM(flightsEntity.getAppendixEntity().getAirportsEntity().getBOM());
            airports.setDEL(flightsEntity.getAppendixEntity().getAirportsEntity().getDEL());

            Providers providers = new Providers();
            providers.set1(flightsEntity.getAppendixEntity().getProvidersEntity().get1());
            providers.set2(flightsEntity.getAppendixEntity().getProvidersEntity().get2());
            providers.set3(flightsEntity.getAppendixEntity().getProvidersEntity().get3());
            providers.set4(flightsEntity.getAppendixEntity().getProvidersEntity().get4());


            Appendix appendix = new Appendix();
            appendix.setAirlines(airlines);
            appendix.setAirports(airports);
            appendix.setProviders(providers);

            List<Flight> flightList = new ArrayList<Flight>();
            List<FlightEntity> flightsEntityList = flightsEntity.getFlightEntities();

            if (flightsEntityList.size() != 0) {
                flightsEntity.getFlightEntities();
                for (FlightEntity flightEntity : flightsEntityList) {


                    Flight flight = new Flight();
                    flight.setAirlineCode(flightEntity.getAirlineCode());
                    flight.setArrivalTime(flightEntity.getArrivalTime());
                    flight.setClass_(flightEntity.getClass_());
                    flight.setDepartureTime(flightEntity.getDepartureTime());
                    flight.setOriginCode(flightEntity.getOriginCode());
                    flight.setDestinationCode(flightEntity.getDestinationCode());

                    List<Fare> fareList = new ArrayList<Fare>();
                    List<FareEntity> fareEntityList = flightEntity.getFareEntities();

                    if (fareEntityList.size() != 0) {
                        for (FareEntity fareEntity : fareEntityList) {
                            Fare fare = new Fare();
                            fare.setFare(fareEntity.getFare());
                            fare.setProviderId(fareEntity.getProviderId());
                            fareList.add(fare);
                        }
                    }

                    flight.setFares(fareList);


                    flightList.add(flight);
                }
            }

            flights.setAppendix(appendix);
            flights.setFlights(flightList);


        }
        return flights;
    }
}
