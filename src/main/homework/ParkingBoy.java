package main.homework;

import main.homework.Ticket;

import java.util.List;

public class ParkingBoy{
    private Parkable parkable;
    private Pickable pickable;
    private List<ParkingLot> parkingLots;

    public ParkingBoy(Parkable parkable, Pickable pickable, List<ParkingLot> parkingLots) {
        this.parkable = parkable;
        this.pickable = pickable;
        this.parkingLots = parkingLots;
    }

    public Ticket parking(Car car) {
        return this.parkable.parking(car, parkingLots);
    }

    public Car pick(Ticket ticket) {
        return this.pickable.pick(ticket, parkingLots);
    }
}
