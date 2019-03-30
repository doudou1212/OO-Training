package test.day3;

import main.day3.Car;
import main.day3.ParkingLot;
import main.day3.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingPlaceTest {
    @Test
    public void should_get_ticket_when_parking_given_one_parking_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.put(car);
        assertNotNull(ticket);
    }

    @Test
    public void should_not_get_ticket_when_parking_given_no_parking_space() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        assertEquals(null, parkingLot.put(car));
    }

    @Test
    public void should_get_one_ticket_when_parking_two_cars_given_one_parking_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car firstCar = new Car();
        Ticket ticket = parkingLot.put(firstCar);
        assertNotNull(ticket);
        Car secondCar = new Car();
        assertEquals(null, parkingLot.put(secondCar));
    }

    @Test
    public void should_get_two_different_tickets_when_parking_two_cars_given_two_parking_space() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        Ticket firstTicket = parkingLot.put(firstCar);
        assertNotNull(firstTicket);
        Car secondCar = new Car();
        Ticket secondTicket = parkingLot.put(secondCar);
        assertNotNull(secondTicket);
        assertNotEquals(firstTicket, secondTicket);
    }

    @Test
    public void should_get_success_when_pick_up_car_with_valid_ticket_given_car_a_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.put(car);
        assertEquals("success", parkingLot.get(ticket));
    }

    @Test
    public void should_get_failed_when_pick_up_car_with_ticket_given_car_not_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.put(car);
        parkingLot.get(ticket);
        assertEquals("failed", parkingLot.get(ticket));
    }

    @Test
    public void should_get_failed_when_pick_up_car_with_invalid_ticket_given_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.put(car);
        assertEquals("failed", parkingLot.get(new Ticket()));
    }
}
