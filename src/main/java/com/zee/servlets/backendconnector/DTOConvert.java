package com.zee.servlets.backendconnector;

import com.zee.servlets.web.viewmodels.AirportVM;
import com.zee.servlets.web.viewmodels.FlightVM;
import com.zee.servlets.web.viewmodels.OfferVM;
import com.zee.servlets.web.viewmodels.OffersPageVM;
import contract.dto.Airport;
import contract.dto.Flight;
import contract.dto.FlightOffer;
import contract.dto.FlightRoute;

import java.util.ArrayList;

public class DTOConvert {
    public static AirportVM toAirportVm(Airport dto) {
        return new AirportVM(dto.getIata(), dto.getName());
    }

    public static FlightVM toFlightVm(Flight dto) {
        return new FlightVM(
                dto.getId(),
                dto.getDepDate(),
                dto.getArrDate(),
                dto.getAirplane().getCapacity(),
                dto.getAirplane().getIata(),
                DTOConvert.toAirportVm(dto.getDepAirport()),
                DTOConvert.toAirportVm(dto.getArrAirport())
        );
    }

    public static OfferVM toOfferVm(FlightOffer dto) {
        ArrayList<FlightVM> outFlights = new ArrayList<>();
        for (Flight flight : dto.getOutRoute().getFlights()) {
            outFlights.add(DTOConvert.toFlightVm(flight));
        }
        ArrayList<FlightVM> returnFlights = new ArrayList<>();
        if (!dto.isOneWay()) {
            for (Flight flight : dto.getReturnRoute().getFlights()) {
                returnFlights.add(DTOConvert.toFlightVm(flight));
            }
        }
        return new OfferVM(
                dto.getPrice(),
                outFlights,
                returnFlights
        );
    }
}
