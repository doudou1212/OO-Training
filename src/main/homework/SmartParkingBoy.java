package main.homework;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingMan{
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public Ticket parking(Car car) {
        final Ticket[] ticket = new Ticket[1];
        getParkingLots().stream()
                .max(Comparator.comparing(parkingLot -> parkingLot.getAvailbaleSpaces()))
                .filter(value -> value.getAvailbaleSpaces() > 0)
                .ifPresent(value -> ticket[0] = value.parking(car));
        return ticket[0];
    }
}
