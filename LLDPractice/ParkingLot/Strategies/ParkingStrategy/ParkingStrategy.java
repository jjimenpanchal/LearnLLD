package LearnLLD.LLDPractice.ParkingLot.Strategies.ParkingStrategy;

import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.Floor;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlot;
import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;
import LearnLLD.LLDPractice.ParkingLot.exceptions.NoSlotFoundException;

import java.util.List;

public interface ParkingStrategy {
    ParkingSlot findParkingSlot(List<Floor> floors, VehicleType vehicleType) throws NoSlotFoundException;
}
