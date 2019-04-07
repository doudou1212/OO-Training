package test;

import main.homework.ParkingLot;
import main.homework.Ticket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingManagerTest {
    @Test
    public void should_get_parking_ticket_when_parking_given_parking_manager_has_one_avaliable_parking_lot_and_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);
        ParkingManager parkingManager = new ParkingManager(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingManager.parking(car);
        assertSame(car, parkingLot.pick(ticket));
    }
}
