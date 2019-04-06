package main.homework;

import main.homework.Ticket;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isAvailable())
                .findFirst()
                .orElseGet(null).parking(car);
    }
}
