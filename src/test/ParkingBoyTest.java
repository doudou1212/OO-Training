package test;

import main.homework.Ticket;
import main.homework.Car;
import main.homework.ParkingBoy;
import main.homework.ParkingLot;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void should_parking_into_first_parking_lot_when_parking_given_parking_boy_has_two_lots_1st_has_one_space_2nd_has_two_spaces() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        assertSame(car, parkingLot1.pick(ticket));
    }

    @Test
    public void should_parking_failed_when_parking_given_parking_boy_has_one_full_parking_lot() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLot1.parking(new Car());
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        assertNull(parkingBoy.parking(car));
    }

    @Test
    public void should_get_car_when_pick_up_given_the_car_in_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        assertSame(car, parkingBoy.pick(ticket));
    }

    @Test
    public void should_not_get_car_when_pick_up_given_the_car_not_in_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        assertNull(parkingBoy.pick(new Ticket()));
    }

    @Test
    public void should_get_car_at_first_time_not_get_car_second_time_when_pick_up_twice_given_the_car_in_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        assertSame(car, parkingBoy.pick(ticket));
        assertNull(parkingBoy.pick(ticket));
    }
}