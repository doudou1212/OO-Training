package test;

import main.homework.Car;
import main.homework.ParkingLot;
import main.homework.Ticket;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ParkingLotTest {
    @Test
    public void should_get_ticket_when_parking_given_an_available_parking_lot() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);
        assertNotNull(ticket);
    }
}
