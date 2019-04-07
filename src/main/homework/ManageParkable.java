package main.homework;

import java.util.List;

public interface ManageParkable extends Parkable{
    public Ticket parking(Car car, List<ParkingLot> parkingLots);
    public Ticket parking(Car car, List<ParkingBoy> boys, List<ParkingLot> parkingLots);
}
