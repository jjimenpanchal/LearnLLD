package LearnLLD.LLDPractice.ParkingLot.classes.Gate;

import LearnLLD.LLDPractice.ParkingLot.Strategies.CalculateParkingChargesStrategy.CalculateParkingChargesStrategy;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlotManager;
import LearnLLD.LLDPractice.ParkingLot.classes.Ticket;

import java.util.Date;

public class ExitGate extends Gate {
    ParkingSlotManager parkingSlotManager;
    CalculateParkingChargesStrategy calculateParkingChargesStrategy;

    public void processVehicleExit(Ticket ticket) {
        ticket.setExitAt(new Date());
        double price = calculateParkingChargesStrategy.calculateParkingCharges(ticket);
        ticket.setPrice(price);
        ticket.getParkingSlot().vacate();
        System.out.println("Vehicle Exit Processsing for Vehicle Type: " + ticket.getVehicleType());

    }

    public ExitGate(CalculateParkingChargesStrategy calculateParkingChargesStrategy) {
        this.calculateParkingChargesStrategy = calculateParkingChargesStrategy;
//        this.parkingSlotManager = new ParkingSlotManager();
    }

    public void setCalculateParkingChargesStrategy(CalculateParkingChargesStrategy calculateParkingChargesStrategy) {
        this.calculateParkingChargesStrategy = calculateParkingChargesStrategy;
    }

}
