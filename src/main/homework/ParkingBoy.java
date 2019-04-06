package main.homework;

import main.homework.Ticket;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        final Ticket[] ticket = new Ticket[1];
        parkingLots.stream()
                .filter(parkingLot -> parkingLot.isAvailable())
                .findFirst().ifPresent(value -> ticket[0] = value.parking(car));
        return ticket[0];
    }

    public Car pick(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.isValidTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        return null;
    }
}
