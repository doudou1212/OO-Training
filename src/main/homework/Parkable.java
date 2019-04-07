package main.homework;

import java.util.List;

public interface Parkable {
    public Ticket parking(Car car, List<ParkingLot> parkingLots);
}
