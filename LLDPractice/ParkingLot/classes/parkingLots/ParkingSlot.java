package LearnLLD.LLDPractice.ParkingLot.classes.parkingLots;

import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;

public interface ParkingSlot {
    static int id = 0;
    void occupy();
    void vacate();
    boolean isAvailable();
    double getPrice();
    VehicleType getParkableVehicle();

}
