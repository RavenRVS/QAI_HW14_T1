package ru.netology.qai.javaforqai.hw14.task1.data;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int cost;
    protected String airportFrom;
    protected String airportTo;
    protected int flightTime;

    public Ticket(int id, int cost, String airportFrom, String airportTo, int flightTime) {
        this.id = id;
        this.cost = cost;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket o) {

        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }
}

