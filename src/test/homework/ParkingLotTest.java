package test.homework;

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

    @Test
    public void should_get_two_different_tickets_when_parking_two_cars_given_an_parking_lot_with_two_places() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car firstCar = new Car();
        Car secondCar = new Car();
        Ticket ticke1 = parkingLot.parking(firstCar);
        Ticket ticket2 = parkingLot.parking(secondCar);
        assertNotEquals(ticke1, ticket2);
    }

    @Test
    public void should_get_car_when_picking_with_ticket_given_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        Ticket ticket = parkingLot.parking(myCar);
        assertSame(myCar, parkingLot.pick(ticket));
    }

    @Test
    public void shoud_get_car_at_first_time_failed_at_second_time_when_picking_with_ticket_given_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        Ticket ticket = parkingLot.parking(myCar);
        assertSame(myCar, parkingLot.pick(ticket));
        assertNull(parkingLot.pick(ticket));
    }

    @Test
    public void shoud_not_get_when_picking_with_invalid_ticket_given_car_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car myCar = new Car();
        Ticket ticket = parkingLot.parking(myCar);
        assertNull(parkingLot.pick(new Ticket()));
    }

    @Test
    public void should_not_get_car_when_picking_with_ticket_given_car_not_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertNull(parkingLot.pick(new Ticket()));
    }

    @Test
    public void paring_lot_should_be_avaliable_when_parking_capacity_larger_than_cars_count() {
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car();
        parkingLot.parking(car);
        assertTrue(parkingLot.isAvailable());

    }

    @Test
    public void paring_lot_should_not_be_avaliable_when_parking_capacity_equals_to_cars_count() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.parking(car);
        assertFalse(parkingLot.isAvailable());

    }

    @Test
    public void should_return_true_if_ticket_is_valid() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.parking(car);
        assertTrue(parkingLot.isValidTicket(ticket));
    }

    @Test
    public void should_return_false_if_ticket_is_not_valid() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.parking(car);
        assertFalse(parkingLot.isValidTicket(new Ticket()));
    }

    @Test
    public void should_return_one_when_paring_lot_has_one_available_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertEquals(1, parkingLot.getAvailbaleSpaces());
    }

    @Test
    public void should_return_zero_when_paring_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parking(new Car());
        assertEquals(0, parkingLot.getAvailbaleSpaces());
    }

    @Test
    public void should_return_parking_rate_05_when_parking_capacity_is_2_parking_space_is_one() {
        ParkingLot parkingLot = new ParkingLot(2);
        parkingLot.parking(new Car());
        assertEquals(0.5, parkingLot.getParkingRate(), 0.0);
    }

    @Test
    public void should_return_parking_rate_0_when_parking_lot_is_full() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.parking(new Car());
        assertEquals(0.0, parkingLot.getParkingRate(), 0.0);
    }
}
