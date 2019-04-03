package main.day4;

import java.util.HashMap;
import java.util.Map;

public class SuperParkingBoy extends Parker{
    public SuperParkingBoy(ParkingLot[] parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) throws NoFreeParkingSpaceException{
        double rate = 0.0;
        Map<Integer, ParkingLot> availableLots = new HashMap<>();
        int index = 0;
        ParkingLot[] parkingLots = getParkingLots();
        for (int i=0; i< parkingLots.length; i++) {
            if ((double)parkingLots[i].getAvailableSpaces()/(double)parkingLots[i].getCapacity() > rate) {
                rate = (double)parkingLots[i].getAvailableSpaces()/(double)parkingLots[i].getCapacity();
                index = i;
            }
        }
        for (int i=0; i< parkingLots.length; i++) {
            if((double)parkingLots[i].getAvailableSpaces()/(double)parkingLots[i].getCapacity() == rate) {
                availableLots.put(new Integer(index), parkingLots[i]);
            }
        }
        System.out.println(availableLots);
        System.out.println(index);
        for(int i=0; i< availableLots.size()-1; i++) {
            if(availableLots.get(i).getAvailableSpaces() > availableLots.get(i+1).getAvailableSpaces()) {
                index = i;
            }
        }
        if(parkingLots[index].getAvailableSpaces() > 0) {
            return parkingLots[index].park(car);
        }
        throw new NoFreeParkingSpaceException();
    }
}
