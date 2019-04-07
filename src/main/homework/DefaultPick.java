package main.homework;

import java.util.List;

public class DefaultPick implements Pickable {
    public Car pick(Ticket ticket, List<ParkingLot>parkingLots) {
        for (ParkingLot parkingLot : parkingLots) {
            if(parkingLot.isValidTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        return null;
    }
}
