package main.day4;


public class ParkingBoy {
    private final ParkingLot[] parkingLots;

    public ParkingBoy(final ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) throws NoFreeParkingSpaceException, AllParkingLotIsNotAvaliableExpception {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isAvailable()) {
                return parkingLot.park(car);
            }
        }
        throw new AllParkingLotIsNotAvaliableExpception();
    }

    public Car pick(Ticket ticket) throws InvalidTicketException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isVaildTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
