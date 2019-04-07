package main.homework;

import java.util.List;

public class ParkingManager extends ParkingMan{
    public ParkingManager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket parking(Car car) {
        return getParkingLots().get(0).parking(car);
    }
}
