package test.day4;

import main.day4.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class SmartParkingBoyTest {
    @Test
    public void should_park_to_second_lot_when_first_has_one_place_sencond_has_two_places_given_two_parking_lots() throws InvalidTicketException, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        assertSame(car, parkingLot2.pick(ticket));
    }

    @Test
    public void should_park_to_first_lot_when_first_has_two_places_sencond_has_one_places_given_two_parking_lots() throws InvalidTicketException, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        assertSame(car, parkingLot1.pick(ticket));
    }

    @Test
    public void should_park_to_first_lot_when_first_has_one_place_sencond_has_one_places_given_two_parking_lots() throws InvalidTicketException, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        assertSame(car, parkingLot1.pick(ticket));
    }

    @Test
    public void should_pick_my_car_when_may_car_parking_in_lots_given_two_parking_lots() throws NoFreeParkingSpaceException, InvalidTicketException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        assertSame(car, smartParkingBoy.pick(ticket));
    }

    @Test(expected = InvalidTicketException.class)
    public void should_not_pick_my_car_when_may_car_not_parking_in_lots_given_two_parking_lots() throws InvalidTicketException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);
        Ticket ticket = new Ticket();
        smartParkingBoy.pick(ticket);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_pick_my_car_failed_at_second_when_may_car_parking_in_lots_given_two_parking_lots() throws InvalidTicketException, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.park(car);
        assertSame(car, smartParkingBoy.pick(ticket));
        smartParkingBoy.pick(ticket);
    }
}
