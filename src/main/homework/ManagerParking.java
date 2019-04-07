package main.homework;

import java.util.List;

public class ManagerParking implements ManageParkable {
    @Override
    public Ticket parking(Car car, List<ParkingLot> parkingLots) {
        final Ticket[] ticket = new Ticket[1];
        parkingLots.stream()
                .filter(parkingLot -> parkingLot.isAvailable())
                .findFirst().ifPresent(value -> ticket[0] = value.parking(car));
        return ticket[0];
    }

    @Override
    public Ticket parking(Car car, List<ParkingBoy> boys, List<ParkingLot> parkingLots) {
        final Ticket[] ticket = new Ticket[1];
        boys.stream()
                .filter(boy -> boy.isParkingLotsAvailable())
                .findFirst()
                .ifPresent(boy -> ticket[0] = boy.parking(car));
        return ticket[0];
    }
}
