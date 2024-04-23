package LearnLLD.LLDPractice.ParkingLot;

import LearnLLD.LLDPractice.ParkingLot.Strategies.CalculateParkingChargesStrategy.HourlyCalculateParkingChargesStrategy;
import LearnLLD.LLDPractice.ParkingLot.classes.Gate.EntryGate;
import LearnLLD.LLDPractice.ParkingLot.classes.Gate.ExitGate;
import LearnLLD.LLDPractice.ParkingLot.classes.Ticket;
import LearnLLD.LLDPractice.ParkingLot.classes.VehicleType;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.Floor;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.FourWhelerParkingSlot;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.ParkingSlot;
import LearnLLD.LLDPractice.ParkingLot.classes.parkingLots.TwoWheelerParkingSlot;
import LearnLLD.LLDPractice.ParkingLot.exceptions.NoSlotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static Scanner sc = new Scanner(System.in);
    static List<Ticket> tickets = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Starting Parking Lot System ... ");

        EntryGate entryGate = new EntryGate();
        // setting up parking lot
        List<Floor> floors = createParkingSlots();
        entryGate.setFloors(floors);
        runParkingLotSystem(entryGate);




    }

    static List<Floor> createParkingSlots() {
        List<Floor> floors = new ArrayList<>();
        System.out.println("Press 1 to create your own parking slots, Press 2 to choose default/existing " +
                "parking slots");
        int choice = sc.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Invalid choice, Press 1 to create your own parking slots, Press 2 to choose " +
                    "default/existing parking slots");
            choice = sc.nextInt();
        }
        if (choice == 1) {
            System.out.println("Enter number of floors: ");
            int noOfFloors = sc.nextInt();
            while (noOfFloors <= 0) {
                System.out.println("Invalid number of floors, Enter number of floors: ");
                noOfFloors = sc.nextInt();
            }
            for (int i = 0; i < noOfFloors; i++) {
                Floor floor = new Floor();
                System.out.println("Enter number of parking slots for floor " + (i + 1) + ": ");
                int noOfParkingSlots = sc.nextInt();
                List<ParkingSlot> parkingSlots = new ArrayList<>();
                for (int j = 0; j < noOfParkingSlots; j++) {
                    System.out.println("Enter 1 for TwoWheelerParkingSlot, 2 for FourWhelerParkingSlot");
                    int parkingSlotType = sc.nextInt();
                    if (parkingSlotType == 1) {
                        parkingSlots.add(new TwoWheelerParkingSlot());
                    } else if (parkingSlotType == 2) {
                        parkingSlots.add(new FourWhelerParkingSlot());
                    } else {
                        System.out.println("Invalid choice, Enter 1 for TwoWheelerParkingSlot, 2 for " +
                                "FourWhelerParkingSlot");
                        j--;
                    }
                }
                floor.setParkingSlots(parkingSlots);
                floors.add(floor);
            }
            System.out.println("Parking slots created successfully");
            return floors;
        }

        int noOfFloors = 5;
        for (int i = 0; i < noOfFloors; i++) {
            Floor floor = new Floor();
            int noOfParkingSlots = 2;
            List<ParkingSlot> parkingSlots = new ArrayList<>();
            parkingSlots.add(new TwoWheelerParkingSlot());
            parkingSlots.add(new FourWhelerParkingSlot());
            floor.setParkingSlots(parkingSlots);
            floors.add(floor);
        }

        return floors;
    }

    static Ticket findTicketFromTicketNumber(int ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                return ticket;
            }
        }

        return null;
    }

    static void runParkingLotSystem(EntryGate entryGate) {
        System.out.println("Parking Lot System started ... ");
        while(true) {
            System.out.println("Press 1 for vehicle entry, Press 2 to exit vehicle from parking lot, press -1 to exit the system");
            int choice = Main.sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter 1 for TwoWheeler, 2 for FourWheeler");
                    int vehicleType = sc.nextInt();
                    if (vehicleType == 1) {
                        Ticket ticket;
                        try {
                            ticket = entryGate.ProcessVehicleEntry(VehicleType.TWO_WHEELER);
                        } catch (NoSlotFoundException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        tickets.add(ticket);
                        System.out.println("Vehicle entry successful");
                        ticket.printTicket();
                    } else if (vehicleType == 2) {
                        Ticket ticket;
                        try {
                            ticket = entryGate.ProcessVehicleEntry(VehicleType.FOUR_WHEELER);
                        } catch (NoSlotFoundException e) {
                            System.out.println(e.getMessage());
                            break;
                        }

                        tickets.add(ticket);
                        System.out.println("Vehicle entry successful");
                        ticket.printTicket();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                    System.out.println("Enter ticket number: ");
                    int ticketNumber = sc.nextInt();
                    Ticket ticket = findTicketFromTicketNumber(ticketNumber);
                    if (ticket == null) {
                        System.out.println("Invalid ticket number");
                        break;
                    }
                    ExitGate exitGate = new ExitGate(new HourlyCalculateParkingChargesStrategy());
                    exitGate.processVehicleExit(ticket);
                    ticket.printTicket();
                    System.out.println("Vehicle exited successfully");
                    break;
                case -1:
                    System.out.println("Exiting the system ... ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, Press 1 for vehicle entry, Press 2 to exit vehicle from parking lot, press -1 to exit the system");
            }
        }
    }

}
