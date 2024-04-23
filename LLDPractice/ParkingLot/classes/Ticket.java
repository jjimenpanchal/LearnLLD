package LearnLLD.LLDPractice.ParkingLot.classes;

import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlot;

import java.util.Date;

public class Ticket {
     public static int counter = 0;
     int id = 0;
     VehicleType vehicleType;
     ParkingSlot parkingSlot;
     Date issuedAt;
     Date exitAt;
     double price;



     public VehicleType getVehicleType() {
          return vehicleType;
     }

     public ParkingSlot getParkingSlot() {
          return parkingSlot;
     }

     public Date getExitAt() {
          return exitAt;
     }

     public void setExitAt(Date exitAt) {
          this.exitAt = exitAt;
     }

     public Date getIssuedAt() {
          return issuedAt;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     public void setParkingSlot(ParkingSlot parkingSlot) {
          this.parkingSlot = parkingSlot;
     }

     public void setIssuedAt(Date issuedAt) {
          this.issuedAt = issuedAt;
     }

     public void setVehicleType(VehicleType vehicleType) {
          this.vehicleType = vehicleType;
     }

     public void setId(int id) {
          this.id = id;
     }

     public int getId() {
          return id;
     }

     public int getTicketNumber() {
          return id;
     }

     public void printTicket() {
          System.out.println("Ticket ID: " + id);
          System.out.println("Vehicle Type: " + vehicleType);
          System.out.println("Parking Slot: " + parkingSlot);
          System.out.println("Issued At: " + issuedAt);
          System.out.println("Exit At: " + exitAt);
          System.out.println("Price: " + price);
     }
}
