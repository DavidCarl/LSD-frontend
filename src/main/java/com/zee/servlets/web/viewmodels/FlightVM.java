package com.zee.servlets.web.viewmodels;

import java.util.Date;

public class FlightVM {
    private long id;
    private Date depDate;
    private Date arrDate;
    private int planeCapacity;
    private String carrierIata;
    private AirportVM depAirport;
    private AirportVM arrAirport;

    public FlightVM() {
    }

    public FlightVM(long id, Date depDate, Date arrDate, int planeCapacity, String carrierIata, AirportVM depAirport, AirportVM arrAirport) {
        this.id = id;
        this.depDate = depDate;
        this.arrDate = arrDate;
        this.planeCapacity = planeCapacity;
        this.carrierIata = carrierIata;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getDepDate() {
        return depDate;
    }
    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }
    public Date getArrDate() {
        return arrDate;
    }
    public void setArrDate(Date arrDate) {
        this.arrDate = arrDate;
    }
    public int getPlaneCapacity() {
        return planeCapacity;
    }
    public void setPlaneCapacity(int planeCapacity) {
        this.planeCapacity = planeCapacity;
    }
    public String getCarrierIata() {
        return carrierIata;
    }
    public void setCarrierIata(String carrierIata) {
        this.carrierIata = carrierIata;
    }
    public AirportVM getDepAirport() {
        return depAirport;
    }
    public void setDepAirport(AirportVM depAirport) {
        this.depAirport = depAirport;
    }
    public AirportVM getArrAirport() {
        return arrAirport;
    }
    public void setArrAirport(AirportVM arrAirport) {
        this.arrAirport = arrAirport;
    }

    @Override
    public String toString() {
        return "FlightVM{" +
                "id=" + id +
                ", depDate=" + depDate +
                ", arrDate=" + arrDate +
                ", planeCapacity=" + planeCapacity +
                ", planeIata='" + carrierIata + '\'' +
                ", depAirport=" + depAirport +
                ", arrAirport=" + arrAirport +
                '}';
    }
}
