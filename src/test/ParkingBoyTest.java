package test;

import main.homework.*;
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
        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);
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
        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);
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
        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);
//        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
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
        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);
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
        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);
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
        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);
        assertNull(parkingBoy.pick(new Ticket()));
    }

    @Test
    public void should_get_car_at_first_time_not_get_car_second_time_when_pick_up_twice_given_the_car_in_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.parking(car);
        assertSame(car, parkingBoy.pick(ticket));
        assertNull(parkingBoy.pick(ticket));
    }

    @Test
    public void should_return_true_when_has_one_available_parking_lot() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(0);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);

        assertTrue(parkingBoy.isParkingLotsAvailable());
    }

    @Test
    public void should_return_false_when_has_no_available_parking_lot() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(0);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        DefaultParking defaultParking = new DefaultParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, parkingLots);

        assertFalse(parkingBoy.isParkingLotsAvailable());
    }
}
