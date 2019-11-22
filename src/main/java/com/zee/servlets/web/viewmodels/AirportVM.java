package com.zee.servlets.web.viewmodels;

public class AirportVM {
    private String iata;
    private String name;

    public AirportVM() {
    }

    public AirportVM(String iata, String name) {
        this.iata = iata;
        this.name = name;
    }

    public String getIata() {
        return iata;
    }
    public void setIata(String iata) {
        this.iata = iata;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AirportVM{" +
                "iata='" + iata + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
