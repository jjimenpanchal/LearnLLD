package LearnLLD.LLDPractice.ParkingLot.classes.Gate;

import LearnLLD.LLDPractice.ParkingLot.Strategies.ParkingStrategy.FillFirstParkingStrategy;
import LearnLLD.LLDPractice.ParkingLot.classes.Ticket;
import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.Floor;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlot;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlotManager;
import LearnLLD.LLDPractice.ParkingLot.exceptions.NoSlotFoundException;

import java.util.Date;
import java.util.List;

public class EntryGate extends Gate {
    ParkingSlotManager parkingSlotManager;

    public EntryGate() {
        this.parkingSlotManager = new ParkingSlotManager(new FillFirstParkingStrategy());
    }

    public void setFloors(List<Floor> floors) {
        this.parkingSlotManager.setFloors(floors);
    }

    public Ticket ProcessVehicleEntry(VehicleType vehicleType) throws NoSlotFoundException {
        Ticket ticket = new Ticket();
        ParkingSlot parkingSlot = parkingSlotManager.getAvailableParkingSlot(vehicleType);
        parkingSlot.occupy();
        ticket.setId(Ticket.counter++);
        ticket.setParkingSlot(parkingSlot);
        ticket.setVehicleType(vehicleType);
        ticket.setIssuedAt(new Date());
        System.out.println("Vehicle Entry Processsing for Vehicle Type: " + vehicleType);
        return ticket;
    }
}
