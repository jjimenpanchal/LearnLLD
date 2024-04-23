package LearnLLD.LLDPractice.ParkingLot.Strategies.CalculateParkingChargesStrategy;

import LearnLLD.LLDPractice.ParkingLot.classes.Ticket;

public class defaultCalculateParkingChargesStrategy implements CalculateParkingChargesStrategy{
    @Override
    public double calculateParkingCharges(Ticket ticket) {
        System.out.println("insIde defaultCalculateParkingChargesStrategy.calculateParkingCharges()");
        return 0;
    }
}
