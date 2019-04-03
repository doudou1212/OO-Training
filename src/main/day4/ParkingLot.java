package main.day4;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final Map<Ticket, Car> parkingSpaces = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return parkingSpaces.size() < capacity;
    }

    public int getAvailableSpaces() {
        return capacity - parkingSpaces.size();
    }

    public Ticket park(Car car) throws NoFreeParkingSpaceException {
        if (isAvailable()) {
            Ticket ticket = new Ticket();
            this.parkingSpaces.put(ticket, car);
            return ticket;
        }
        throw new NoFreeParkingSpaceException();
    }

    public boolean isVaildTicket(Ticket ticket) {
        return parkingSpaces.containsKey(ticket);
    }

    public Car pick(Ticket ticket) throws InvalidTicketException {
        if (isVaildTicket(ticket)) {
            return parkingSpaces.remove(ticket);
        }
        throw new InvalidTicketException();
    }
}
