package main.homework;

import main.day4.Ticket;

import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots;
    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        return new Ticket();
    }
}
