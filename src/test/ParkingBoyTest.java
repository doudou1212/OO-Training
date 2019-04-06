package test;

import main.homework.Ticket;
import main.homework.Car;
import main.homework.ParkingBoy;
import main.homework.ParkingLot;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ParkingBoyTest {
    @Test
    public void should_get_ticket_when_parking_given_parking_boy_has_one_parking_lot_with_one_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parking(new Car());
        assertNotNull(ticket);
    }

    @Test
    public void should_parking_into_first_parking_lot_when_parking_given_parking_boy_has_two_lots_with_one_space() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        assertSame(car, parkingLot1.pick(ticket));
    }
}
