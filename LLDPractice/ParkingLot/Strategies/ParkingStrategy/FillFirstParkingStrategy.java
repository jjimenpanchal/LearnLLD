package LearnLLD.LLDPractice.ParkingLot.Strategies.ParkingStrategy;

import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.Floor;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlot;
import LearnLLD.LLDPractice.ParkingLot.exceptions.NoSlotFoundException;

import java.util.List;

public class FillFirstParkingStrategy implements ParkingStrategy{
    @Override
    public ParkingSlot findParkingSlot(List<Floor> floors, VehicleType vehicleType) throws NoSlotFoundException{
        for (Floor floor : floors) {
            List<ParkingSlot> parkingSlots = floor.getParkingSlots();
            for (ParkingSlot parkingSlot : parkingSlots) {
                if (parkingSlot.isAvailable() && parkingSlot.getParkableVehicle().equals(vehicleType)) {
                    return parkingSlot;
                }
            }
        }
        throw new NoSlotFoundException("No slot found for vehicle type: Either Parking lot is full for this vehicle type " +
                "or we do not support this vehicle type" + vehicleType);

    }
}
