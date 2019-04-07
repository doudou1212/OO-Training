package main.homework;

import java.util.List;

public class ManagePick implements ManagePickable {
    @Override
    public Car pick(Ticket ticket, List<ParkingLot> parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.isValidTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        return null;
    }

    @Override
    public Car pick(Ticket ticket, List<ParkingBoy> boys, List<ParkingLot> parkingLots) {
        for (ParkingBoy boy : boys) {
            Car car = boy.pick(ticket);
            if (car != null) {
                return car;
            }
        }

        return this.pick(ticket, parkingLots);
    }
}
