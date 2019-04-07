package main.homework;

import java.util.List;

public interface Pickable {
    public Car pick(Ticket ticket, List<ParkingLot> parkingLots);
}
