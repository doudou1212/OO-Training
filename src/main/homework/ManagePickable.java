package main.homework;

import java.util.List;

public interface ManagePickable extends Pickable{
    public Car pick(Ticket ticket, List<ParkingLot> parkingLots);
    public Car pick(Ticket ticket, List<ParkingBoy> boys, List<ParkingLot> parkingLots);
}
