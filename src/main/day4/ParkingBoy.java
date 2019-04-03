package main.day4;


public class ParkingBoy extends Parker{

    public ParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NoFreeParkingSpaceException,AllParkingLotIsNotAvaliableExpception {
        for (ParkingLot parkingLot : getParkingLots()) {
            if (parkingLot.isAvailable()) {
                return parkingLot.park(car);
            }
        }
        throw new AllParkingLotIsNotAvaliableExpception();
    }
}
