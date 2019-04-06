package main.homework;

import main.homework.Ticket;

import java.util.List;

public class ParkingBoy extends ParkingMan{
    public ParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        final Ticket[] ticket = new Ticket[1];
        getParkingLots().stream()
                .filter(parkingLot -> parkingLot.isAvailable())
                .findFirst().ifPresent(value -> ticket[0] = value.parking(car));
        return ticket[0];
    }
}
