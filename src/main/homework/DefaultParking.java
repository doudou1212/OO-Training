package main.homework;

import java.util.List;

public class DefaultParking implements Parkable {
    public Ticket parking(Car car, List<ParkingLot> parkingLots) {
        final Ticket[] ticket = new Ticket[1];
        parkingLots.stream()
                .filter(parkingLot -> parkingLot.isAvailable())
                .findFirst().ifPresent(value -> ticket[0] = value.parking(car));
        return ticket[0];
    }
}
