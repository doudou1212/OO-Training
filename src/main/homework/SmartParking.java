package main.homework;

import java.util.Comparator;
import java.util.List;

public class SmartParking implements Parkable {
    public Ticket parking(Car car, List<ParkingLot> parkingLots) {
        final Ticket[] ticket = new Ticket[1];
        parkingLots.stream()
                .max(Comparator.comparing(parkingLot -> parkingLot.getAvailbaleSpaces()))
                .filter(value -> value.getAvailbaleSpaces() > 0)
                .ifPresent(value -> ticket[0] = value.parking(car));
        return ticket[0];
    }
}
