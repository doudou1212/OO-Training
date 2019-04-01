package main.day4;

public class SmartParkingBoy {
    private final ParkingLot[] parkingLots;

    public SmartParkingBoy(final ParkingLot[] parkingLots) {
        this.parkingLots = parkingLots;
    }
    public Ticket parking(Car car) throws NoFreeParkingSpaceException {
        ParkingLot availableParkingLot = getMostSpareParkingLotIndex();
        if (availableParkingLot.getAvailableSpaces() > 0 ) {
            return availableParkingLot.park(car);
        }
        throw new NoFreeParkingSpaceException();
    }

    private ParkingLot getMostSpareParkingLotIndex() {
        int index = -1;
        int availableSpaces = -1;
        for (int i = 0; i < parkingLots.length; i++) {
            if(parkingLots[i].getAvailableSpaces() > availableSpaces) {
                availableSpaces = parkingLots[i].getAvailableSpaces();
                index = i;
            }
        }
        return parkingLots[index];
    }

    public Car pick(Ticket ticket) throws InvalidTicketException {
        for (ParkingLot parkinglot : parkingLots) {
            if (parkinglot.isVaildTicket(ticket)) {
                return parkinglot.pick(ticket);
            }
        }
        throw new InvalidTicketException();
    }
}
