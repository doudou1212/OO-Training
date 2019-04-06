package main.homework;

import java.util.List;

public abstract class ParkingMan {
    private List<ParkingLot> parkingLots;

    public ParkingMan(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public Car pick(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.isValidTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        return null;
    }

    public abstract Ticket parking(Car car);
}
