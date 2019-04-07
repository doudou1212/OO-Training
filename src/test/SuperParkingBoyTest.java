package test;

import main.homework.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;
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

    @Test
    public void should_park_at_first_parking_lot_when_parking_given_two_lots_with_rate_50_and_1st_lot_has_two_spaces_2nd_lot_has_one_space() {
        ParkingLot parkingLot1 = new ParkingLot(4);
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
        assertSame(car, parkingLot1.pick(ticket));
    }

    @Test
    public void should_park_at_second_parking_lot_when_parking_given_two_lots_with_rate_50_and_1st_lot_has_one_space_2nd_lot_has_two_spaces() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLot1.parking(new Car());

        ParkingLot parkingLot2 = new ParkingLot(4);
        parkingLot2.parking(new Car());
        parkingLot2.parking(new Car());

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.parking(car);
        assertSame(car, parkingLot2.pick(ticket));
    }

    @Test
    public void should_park_at_first_parking_lot_when_parking_given_two_lots_with_rate_50_and_one_space() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        parkingLot1.parking(new Car());

        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLot2.parking(new Car());

        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.parking(car);
        assertSame(car, parkingLot1.pick(ticket));
    }

    @Test
    public void should_pick_car_success_with_valid_ticket_when_picking_given_parking_boy_has_two_lots_and_the_car_in_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.parking(car);
        assertSame(car, superParkingBoy.pick(ticket));
    }

    @Test
    public void should_pick_car_failed_with_invalid_ticket_when_picking_given_parking_boy_has_two_lots_and_the_car_in_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.parking(car);
        assertNull(superParkingBoy.pick(new Ticket()));
    }
}
