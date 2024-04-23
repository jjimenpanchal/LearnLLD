package LearnLLD.LLDPractice.ParkingLot.Strategies.ParkingStrategy;

import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.Floor;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlot;
import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;

import java.util.List;

public class NearestParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSlot findParkingSlot(List<Floor> floors, VehicleType vehicleType) {
        System.out.println("Inside NearestParkingStrategy.getParkingSlot()");
        return null;
    }
}
