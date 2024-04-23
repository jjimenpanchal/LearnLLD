package LearnLLD.LLDPractice.ParkingLot.Strategies.CalculateParkingChargesStrategy;

import LearnLLD.LLDPractice.ParkingLot.classes.Ticket;

public class HourlyCalculateParkingChargesStrategy implements CalculateParkingChargesStrategy{
    @Override
    public double calculateParkingCharges(Ticket ticket) {
        double priceOfSlot = ticket.getParkingSlot().getPrice();
        // currently considering 100 as fixed price for parking + price of slot per sec
        long secs = (ticket.getExitAt().getTime() - ticket.getIssuedAt().getTime()) / (1000);
        return (priceOfSlot * secs) + 100;
    }
}
