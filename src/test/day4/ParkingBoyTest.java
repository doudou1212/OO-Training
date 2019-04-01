package test.day4;

import main.day4.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ParkingBoyTest {
    @Test
    public void should_parking_at_fist_parking_lot_when_parking_server_parking_given_two_parking_lots() throws InvalidTicketException, AllParkingLotIsNotAvaliableExpception, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);

        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        ParkingBoy parkingBoy = new ParkingBoy(parkinglots);
        Car car = new Car();

        Ticket ticket = parkingBoy.park(car);

        assertNotNull(parkingLot1.pick(ticket));
    }

    @Test
    public void should_parking_fist_car_to_first_parking_lot_second_car_to_second_parking_lot_when_parking_boy_parking_given_two_parking_lots_with_one_lot_each_parking_lot() throws InvalidTicketException, AllParkingLotIsNotAvaliableExpception, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);

        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        ParkingBoy parkingBoy = new ParkingBoy(parkinglots);
        Car car1 = new Car();
        Car car2 = new Car();

        Ticket ticket1 = parkingBoy.park(car1);
        Ticket ticket2 = parkingBoy.park(car2);

        assertNotNull(parkingLot1.pick(ticket1));
        assertNotNull(parkingLot2.pick(ticket2));

    }

    @Test
    public void should_parking_success_when_has_one_parking_space_given_two_parking_lot() throws AllParkingLotIsNotAvaliableExpception, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        ParkingBoy parkingBoy = new ParkingBoy(parkinglots);
        Car car = new Car();
        assertNotNull(parkingBoy.park(car));
    }

    @Test(expected = AllParkingLotIsNotAvaliableExpception.class)
    public void should_parking_failed_when_has_no_parking_space_given_two_parking_lot() throws AllParkingLotIsNotAvaliableExpception, NoFreeParkingSpaceException {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingLot[] parkinglots = new ParkingLot[]{parkingLot1, parkingLot2};
        ParkingBoy parkingBoy = new ParkingBoy(parkinglots);
        parkingBoy.park(new Car());
        parkingBoy.park(new Car());
        assertNotNull(parkingBoy.park(new Car()));
    }
}
