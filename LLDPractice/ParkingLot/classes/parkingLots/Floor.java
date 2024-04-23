package LearnLLD.LLDPractice.ParkingLot.classes.parkingLots;

import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    public List<ParkingSlot> getParkingSlots() {
        return this.parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
