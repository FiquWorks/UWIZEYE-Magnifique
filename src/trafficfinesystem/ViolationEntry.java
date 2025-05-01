package trafficfinesystem;

import java.util.Scanner;

public class ViolationEntry extends TrafficRecord {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void recordViolation() {
        
        do {
            System.out.print("Driver National ID (16 digits): ");
            driverId = scanner.nextLine().trim();
            if (!driverId.matches("\\d{16}")) {
                System.out.println("[Error] ID must be exactly 16 digits.");
            }
        } while (!driverId.matches("\\d{16}"));

        
        do {
            System.out.print("Driver Name: ");
            driverName = scanner.nextLine().trim();
            if (!driverName.matches("[a-zA-Z ]{2,}")) {
                System.out.println("[Error] Name must contain only letters and spaces (min 2 characters).");
            }
        } while (!driverName.matches("[a-zA-Z ]{2,}"));

        
        do {
            System.out.print("Vehicle Plate (e.g., RAB123D): ");
            vehiclePlate = scanner.nextLine().trim().toUpperCase();
            if (!vehiclePlate.matches("^R[A-Z]{2}\\d{3}[A-Z]$")) {
                System.out.println("[Error] Plate must be in format RAB123D.");
            }
        } while (!vehiclePlate.matches("^R[A-Z]{2}\\d{3}[A-Z]$"));

        
        do {
            System.out.print("Violation Type (SPEEDING, RED_LIGHT, NO_HELMET, DUI): ");
            violationType = scanner.nextLine().trim().toUpperCase();
            if (!violationType.matches("SPEEDING|RED_LIGHT|NO_HELMET|DUI")) {
                System.out.println("[Error] Invalid type. Choose from: SPEEDING, RED_LIGHT, NO_HELMET, DUI.");
            }
        } while (!violationType.matches("SPEEDING|RED_LIGHT|NO_HELMET|DUI"));

        paymentStatus = "UNPAID";

        System.out.println("\n--- Violation Recorded ---");
        System.out.println("Name: " + driverName);
        System.out.println("ID: " + driverId);
        System.out.println("Plate: " + vehiclePlate);
        System.out.println("Violation: " + violationType);
        System.out.println("Status: " + paymentStatus + "\n");
    }

    @Override
    public void assessFine() {}

    @Override
    public void processPayment() {}
}
