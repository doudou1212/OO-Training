package main.homework;

import java.util.List;

public class ParkingManager {
    private ManageParkable parkable;
    private ManagePickable pickable;
    private List<ParkingLot> parkingLots;
    private List<ParkingBoy> boys;

    public ParkingManager(ManageParkable parkable, ManagePickable pickable, List<ParkingBoy> boys, List<ParkingLot> parkingLots) {
        this.parkable = parkable;
        this.pickable = pickable;
        this.boys = boys;
        this.parkingLots = parkingLots;
    }

    public ParkingManager(ManageParkable parkable, ManagePickable pickable, List<ParkingBoy> boys) {
        this.parkable = parkable;
        this.pickable = pickable;
        this.boys = boys;
    }

    public Ticket parking(Car car) {
        return this.parkable.parking(car, boys, parkingLots);
    }

    public Car pick(Ticket ticket) {
        if (this.boys != null) {
            return this.pickable.pick(ticket, boys, parkingLots);
        }
        return this.pickable.pick(ticket, parkingLots);
    }
}
