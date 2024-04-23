package LearnLLD.LLDPractice.ParkingLot.classes.parkingLots;

import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;

public class FourWhelerParkingSlot implements ParkingSlot{
//    private int id;
    private int floor;
    private final static double price = 120;
    private ParkingSlotStatus status;
    private VehicleType parkableVehicle = VehicleType.FOUR_WHEELER;

    public FourWhelerParkingSlot() {
        this.status = ParkingSlotStatus.VACANT;
    }

    @Override
    public void occupy() {
        this.status = ParkingSlotStatus.OCCUPIED;
    }

    @Override
    public VehicleType getParkableVehicle() {
        return this.parkableVehicle;
    }

    @Override
    public void vacate() {
        this.status = ParkingSlotStatus.VACANT;
    }

    @Override
    public boolean isAvailable() {
        return this.status == ParkingSlotStatus.VACANT;
    }

    public int getId() {
        return this.id;
    }

    public int getFloor() {
        return this.floor;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public ParkingSlotStatus getStatus() {
        return this.status;
    }
}
