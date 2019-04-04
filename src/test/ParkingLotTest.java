package test;

import main.homework.Car;
import main.homework.ParkingLot;
import main.homework.Ticket;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingLotTest {
    @Test
    public void should_get_ticket_when_parking_given_an_available_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);
        assertNotNull(ticket);
    }

    @Test
    public void should_not_get_ticket_when_parking_given_an_full_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parking(new Car());
        Car myCar = new Car();
        assertNull(parkingLot.parking(myCar));
    }

    @Test
    public void should_get_one_ticket_for_first_car_when_parking_two_cars_given_an_parking_lot_with_one_place() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Ticket ticket = parkingLot.parking(firstCar);
        assertNotNull(ticket);
        assertNull(parkingLot.parking(secondCar));
    }
}
