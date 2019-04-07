package main.homework;

import java.util.Comparator;
import java.util.List;

public class SuperParkingBoy extends ParkingMan {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        final Ticket[] ticket = new Ticket[1];
        getParkingLots().stream()
                .filter(parkingLot -> parkingLot.getAvailbaleSpaces() > 0)
                .sorted(Comparator.comparing(parkingLot -> parkingLot.getParkingRate()))
                .findFirst()
                .ifPresent(parkingLot -> ticket[0] = parkingLot.parking(car));
        return ticket[0];

    }
}
