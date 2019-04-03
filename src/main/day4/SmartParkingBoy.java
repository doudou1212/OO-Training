package main.day4;

public class SmartParkingBoy extends Parker{

    public SmartParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }

    private ParkingLot getMostSpareParkingLotIndex() {
        int index = -1;
        int availableSpaces = -1;
        ParkingLot[] parkingLots = getParkingLots();
        for (int i = 0; i < parkingLots.length; i++) {
            if(parkingLots[i].getAvailableSpaces() > availableSpaces) {
                availableSpaces = parkingLots[i].getAvailableSpaces();
                index = i;
            }
        }
        return parkingLots[index];
    }

    @Override
    public Ticket park(Car car) throws NoFreeParkingSpaceException {
        ParkingLot availableParkingLot = getMostSpareParkingLotIndex();
        if (availableParkingLot.getAvailableSpaces() > 0 ) {
            return availableParkingLot.park(car);
        }
        throw new NoFreeParkingSpaceException();
    }
}
