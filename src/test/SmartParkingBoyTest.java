package test;

import main.homework.Car;
import main.homework.ParkingLot;
import main.homework.SmartParkingBoy;
import main.homework.Ticket;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertSame;

public class SmartParkingBoyTest {
    @Test
    public void should_park_at_second_parking_lot_when_parking_give_smart_parking_boy_has_two_lots_with_1st_lot_has_one_space_2en_lot_has_two_spaces() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parking(car);
        assertSame(car, parkingLot2.pick(ticket));
    }

    @Test
    public void should_park_at_fist_parking_lot_when_parking_give_smart_parking_boy_has_two_lots_with_1st_lot_has_two_spaces_2en_lot_has_one_spaces() {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parking(car);
        assertSame(car, parkingLot1.pick(ticket));
    }

    @Test
    public void should_park_at_fist_parking_lot_when_parking_give_smart_parking_boy_has_two_lots_with_1st_lot_has_one_spaces_2en_lot_has_one_spaces() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parking(car);
        assertSame(car, parkingLot1.pick(ticket));
    }

    @Test
    public void should_park_failed_when_parking_give_smart_parking_boy_has_one_full_lot() {
        ParkingLot parkingLot1 = new ParkingLot(0);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        assertNull(smartParkingBoy.parking(car));
    }

    @Test
    public void should_pick_up_car_when_pick_with_ticket_given_my_car_in_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parking(car);
        assertSame(car, smartParkingBoy.pick(ticket));

    }

    @Test
    public void should_not_pick_up_ca_when_pick_with_invalid_ticket_given_my_car_in_parking_lots() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        Car car = new Car();
        smartParkingBoy.parking(car);
        assertNull(smartParkingBoy.pick(new Ticket()));

    }

}
