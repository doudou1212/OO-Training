package main.day3;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int size;
    private Map<Ticket, Car> parkingSpaces = new HashMap<>();

    public ParkingLot(int size) {
        this.size = size;
    }

    public Ticket put(Car car) {
        if (parkingSpaces.size() < size) {
            Ticket ticket = new Ticket();
            this.parkingSpaces.put(ticket, car);
            return ticket;
        } else {
            return null;
        }
    }

    public String get(Ticket toBeCheckedTicket) {
        for (Ticket ticket : parkingSpaces.keySet()) {
            if (toBeCheckedTicket == ticket) {
                parkingSpaces.remove(ticket);
                return "success";
            }
        }
        return "failed";
    }
}
