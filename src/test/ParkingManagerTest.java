package test;

import main.homework.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;

public class ParkingManagerTest {
    @Test
    public void should_get_parking_ticket_when_parking_given_parking_manager_has_one_avaliable_parking_lot_and_no_parking_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLots.add(parkingLot);

        ManagerParking managerParking = new ManagerParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy manager = new ParkingBoy(managerParking,defaultPick, parkingLots);

        Car car = new Car();
        Ticket ticket = manager.parking(car);
        assertSame(car, parkingLot.pick(ticket));
    }

//    @Test
//    public void should_get_parking_ticket_when_parking_given_parking_manager_has_two_boys_and_each_boy_has_one_available_parking_lot() {
//        ParkingLot boy1ParkingLot = new ParkingLot(1);
//        List<ParkingLot> boy1ParkingLots = new ArrayList<>();
//        boy1ParkingLots.add(boy1ParkingLot);
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(boy1ParkingLots);
//
//        ParkingLot boy2ParkingLot = new ParkingLot(1);
//        List<ParkingLot> boy2ParkingLots = new ArrayList<>();
//        boy2ParkingLots.add(boy2ParkingLot);
//        SuperParkingBoy superParkingBoy = new SuperParkingBoy(boy2ParkingLots);
//
//        List<ParkingMan> boys = new ArrayList<>();
//        ParkingManager parkingManager = new ParkingManager(boys);
//        Car car = new Car();
//        Ticket ticket = parkingManager.parking(car);
//        assertSame(car, parkingManager.pick(ticket));
//    }
}
