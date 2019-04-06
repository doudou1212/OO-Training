package main.homework;

import java.util.List;

public class SmartParkingBoy {
    private List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        final Ticket[] ticket = new Ticket[1];
        parkingLots.stream()
                .max((key, value) -> value.getAvailbaleSpaces())
                .filter(value -> value.getAvailbaleSpaces() > 0)
                .ifPresent(value -> ticket[0] = value.parking(car));
        return ticket[0];
    }

    public Car pick(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isValidTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        return null;
    }
}
