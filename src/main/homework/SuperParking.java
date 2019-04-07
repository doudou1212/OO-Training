package main.homework;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperParking implements Parkable {
    public Ticket parking(Car car, List<ParkingLot> parkingLots) {
        final Ticket[] ticket = new Ticket[1];
        double mostRate = 0.0;
        Optional<ParkingLot> targetParkingLot = parkingLots.stream()
                .max(Comparator.comparing(parkingLot -> parkingLot.getParkingRate()));
        mostRate = targetParkingLot.orElse(null).getParkingRate();

        double finalMostRate = mostRate;
        parkingLots.stream()
                .filter(parkingLot -> parkingLot.getParkingRate() >= finalMostRate && parkingLot.getAvailbaleSpaces() > 0)
                .max(Comparator.comparing(parkingLot -> parkingLot.getAvailbaleSpaces()))
                .ifPresent(parkingLot -> ticket[0] = parkingLot.parking(car));
        return ticket[0];

    }
}
