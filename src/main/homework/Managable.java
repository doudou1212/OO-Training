package main.homework;

import java.util.List;

public interface Managable extends Parkable{
    public Ticket parking(Car car, List<ParkingLot> parkingLots);
    public Ticket parking(Car car, List<ParkingBoy> parkingLots, List<ParkingBoy> boys);
}
