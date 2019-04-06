package test;

import main.day4.Ticket;
import main.homework.Car;
import main.homework.ParkingBoy;
import main.homework.ParkingLot;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

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
}
