package test.day4;

import main.day4.*;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SuperParkingBoyTest {
    @Test
    public void should_park_at_second_parking_lot_when_parking_given_1st_rate_25_2nd_rate_50() throws NoFreeParkingSpaceException, InvalidTicketException {
        ParkingLot parkingLot1 = new ParkingLot(4);
        ParkingLot parkingLot2 = new ParkingLot(2);

        parkingLot1.park(new Car());
        parkingLot1.park(new Car());
        parkingLot1.park(new Car());

        parkingLot2.park(new Car());

        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.park(car);
        assertSame(car, parkingLot2.pick(ticket));
    }

    @Test
    public void should_park_at_second_parking_lot_when_parking_given_rate_50_and_1st_parking_lot_1_space_2nd_parking_lot_2_space() throws NoFreeParkingSpaceException, InvalidTicketException {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(4);

        parkingLot1.park(new Car());

        parkingLot2.park(new Car());
        parkingLot2.park(new Car());

        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.park(car);
        assertSame(car, parkingLot2.pick(ticket));
    }

    @Test
    public void should_park_at_first_parking_lot_when_parking_given_rate_50_and_1st_parking_lot_1_space_2nd_parking_lot_1_space() throws NoFreeParkingSpaceException, InvalidTicketException {
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);

        parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(parkinglots);
        Car car = new Car();
        Ticket ticket = superParkingBoy.park(car);
        assertSame(car, parkingLot1.pick(ticket));
    }
}
