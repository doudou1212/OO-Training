package test;

import main.homework.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

public class SuperParkingBoyTest {
    @Test
    public void should_park_at_second_parking_lot_when_parking_given_1st_lot_rate_25_and_2nd_lot_rate_50() {
        ParkingLot parkingLot1 = new ParkingLot(4);
        parkingLot1.parking(new Car());
        parkingLot1.parking(new Car());
        parkingLot1.parking(new Car());

        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLot2.parking(new Car());

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.parking(car);
        assertSame(car, parkingLot2.pick(ticket));

    }
}
