package LearnLLD.LLDPractice.ParkingLot.classes.parkingLots;

import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;

public class TwoWheelerParkingSlot implements ParkingSlot {
//    int id;
    int floor;
    private static double price = 50;
    ParkingSlotStatus status;
    VehicleType parkableVehicle = VehicleType.TWO_WHEELER;

    public TwoWheelerParkingSlot() {
        this.status = ParkingSlotStatus.VACANT;
    }

    @Override
    public void occupy() {
        this.status = ParkingSlotStatus.OCCUPIED;
    }

    @Override
    public void vacate() {
        this.status = ParkingSlotStatus.VACANT;
    }

    @Override
    public VehicleType getParkableVehicle() {
        return this.parkableVehicle;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public boolean isAvailable() {
        return this.status == ParkingSlotStatus.VACANT;
    }

    public int getId() {
        return this.id;
    }
}
