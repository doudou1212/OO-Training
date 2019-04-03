package main.day4;

public abstract class Parker {

    public ParkingLot[] getParkingLots() {
        return parkingLots;
    }

    private final ParkingLot[] parkingLots;

    public Parker(final ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Car pick(Ticket ticket) throws InvalidTicketException {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isVaildTicket(ticket)) {
                return parkingLot.pick(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    public abstract Ticket park(Car car) throws AllParkingLotIsNotAvaliableExpception, NoFreeParkingSpaceException;
}
