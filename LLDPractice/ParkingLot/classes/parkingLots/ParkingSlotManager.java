package LearnLLD.LLDPractice.ParkingLot.classes.parkingLots;

import LearnLLD.LLDPractice.ParkingLot.Strategies.ParkingStrategy.ParkingStrategy;
import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;
import LearnLLD.LLDPractice.ParkingLot.exceptions.NoSlotFoundException;

import java.util.List;

public class ParkingSlotManager {
    List<Floor> floors;
    ParkingStrategy parkingStrategy;

    public ParkingSlotManager(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public void setParkingStrategy (ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSlot getAvailableParkingSlot(VehicleType vehicleType) throws NoSlotFoundException {
        ParkingSlot parkingSlot = null;
        parkingSlot = parkingStrategy.findParkingSlot(this.floors, vehicleType);
        return parkingSlot;
    }
}
