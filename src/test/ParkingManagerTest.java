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

    @Test
    public void should_get_parking_ticket_when_parking_given_parking_manager_has_two_boys_and_each_boy_has_one_available_parking_lot() {
        ParkingLot boy1ParkingLot = new ParkingLot(1);
        List<ParkingLot> boy1ParkingLots = new ArrayList<>();
        boy1ParkingLots.add(boy1ParkingLot);
        SmartParking smartParking = new SmartParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy smartParkingBoy = new ParkingBoy(smartParking, defaultPick, boy1ParkingLots);


        ParkingLot boy2ParkingLot = new ParkingLot(1);
        List<ParkingLot> boy2ParkingLots = new ArrayList<>();
        boy2ParkingLots.add(boy2ParkingLot);
        SuperParking superParking = new SuperParking();
        ParkingBoy superParkingBoy = new ParkingBoy(superParking, defaultPick, boy2ParkingLots);

        List<ParkingBoy> boys = new ArrayList<>();
        boys.add(smartParkingBoy);
        boys.add(superParkingBoy);

        ManagerParking managerParking = new ManagerParking();
        ManagePick managePick = new ManagePick();
        ParkingManager manager = new ParkingManager(managerParking, managePick, boys);
        Car car = new Car();
        Ticket ticket = manager.parking(car);
        assertSame(car, manager.pick(ticket));
    }

    @Test
    public void should_get_parking_ticket_when_parking_given_parking_manager_has_two_boys_and_one_boy_has_one_available_parking_lot() {
        ParkingLot boy1ParkingLot = new ParkingLot(1);
        List<ParkingLot> boy1ParkingLots = new ArrayList<>();
        boy1ParkingLots.add(boy1ParkingLot);
        SmartParking smartParking = new SmartParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy smartParkingBoy = new ParkingBoy(smartParking, defaultPick, boy1ParkingLots);
        smartParkingBoy.parking(new Car());

        ParkingLot boy2ParkingLot = new ParkingLot(1);
        List<ParkingLot> boy2ParkingLots = new ArrayList<>();
        boy2ParkingLots.add(boy2ParkingLot);
        DefaultParking defaultParking = new DefaultParking();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, boy2ParkingLots);

        List<ParkingBoy> boys = new ArrayList<>();
        boys.add(smartParkingBoy);
        boys.add(parkingBoy);

        ManagerParking managerParking = new ManagerParking();
        ManagePick managePick = new ManagePick();
        ParkingManager manager = new ParkingManager(managerParking, managePick, boys);
        Car car = new Car();
        Ticket ticket = manager.parking(car);
        assertSame(car, manager.pick(ticket));
    }

    @Test
    public void should_get_parking_ticket_when_parking_given_parking_manager_has_two_boys_and_no_boy_has_one_available_parking_lot() {
        ParkingLot boy1ParkingLot = new ParkingLot(1);
        List<ParkingLot> boy1ParkingLots = new ArrayList<>();
        boy1ParkingLots.add(boy1ParkingLot);
        SmartParking smartParking = new SmartParking();
        DefaultPick defaultPick = new DefaultPick();
        ParkingBoy smartParkingBoy = new ParkingBoy(smartParking, defaultPick, boy1ParkingLots);
        smartParkingBoy.parking(new Car());

        ParkingLot boy2ParkingLot = new ParkingLot(1);
        List<ParkingLot> boy2ParkingLots = new ArrayList<>();
        boy2ParkingLots.add(boy2ParkingLot);
        DefaultParking defaultParking = new DefaultParking();
        ParkingBoy parkingBoy = new ParkingBoy(defaultParking, defaultPick, boy2ParkingLots);
        parkingBoy.parking(new Car());

        List<ParkingBoy> boys = new ArrayList<>();
        boys.add(smartParkingBoy);
        boys.add(parkingBoy);

        ManagerParking managerParking = new ManagerParking();
        ManagePick managePick = new ManagePick();
        ParkingLot managerParkingLot = new ParkingLot(1);
        List<ParkingLot> managerParkingLots = new ArrayList<>();
        managerParkingLots.add(managerParkingLot);
        ParkingManager manager = new ParkingManager(managerParking, managePick, boys, managerParkingLots);
        Car car = new Car();
        Ticket ticket = manager.parking(car);
        assertSame(car, manager.pick(ticket));
    }
}
