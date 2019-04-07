package main.homework;

import java.util.List;

public class SuperParkingBoy extends ParkingMan {
    public SuperParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        return getParkingLots().get(1).parking(car);
    }
}
