package main.homework;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity;
    private Map<Ticket, Car> parkingLots = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Ticket parking(Car car) {
        if(parkingLots.size() < capacity) {
            Ticket ticket = new Ticket();
            parkingLots.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car pick(Ticket ticket) {
        Car car = parkingLots.get(ticket);
        parkingLots.remove(ticket);
        return car;
    }

    public boolean isAvailable() {
        return capacity > parkingLots.size();
    }

    public boolean isValidTicket(Ticket ticket) {
        return parkingLots.get(ticket) != null;
    }

    public int getAvailbaleSpaces() {
        return capacity > parkingLots.size() ? capacity - parkingLots.size() : 0;
    }
}
