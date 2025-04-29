package trafficfinesystem;

import java.util.Scanner;

public class ViolationEntry extends TrafficRecord {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void recordViolation() {
        System.out.print("Driver National ID (16 digits): ");
        driverId = scanner.nextLine();
        while (!driverId.matches("\\d{16}")) {
            System.out.print("Invalid ID. Enter exactly 16 digits: ");
            driverId = scanner.nextLine();
        }

        System.out.print("Driver Name: ");
        driverName = scanner.nextLine();
        while (!driverName.matches("[a-zA-Z\\s]+")) {
            System.out.print("Invalid name. Use only letters: ");
            driverName = scanner.nextLine();
        }

        System.out.print("Vehicle Plate (e.g., RAB123D): ");
        vehiclePlate = scanner.nextLine();
        while (!vehiclePlate.matches("[A-Z]{3}\\d{3}[A-Z]")) {
            System.out.print("Invalid plate format. Try again (e.g., RAB123D): ");
            vehiclePlate = scanner.nextLine();
        }

        System.out.print("Violation Type (SPEEDING, RED_LIGHT, NO_HELMET, DUI): ");
        violationType = scanner.nextLine().toUpperCase();
        while (!violationType.matches("SPEEDING|RED_LIGHT|NO_HELMET|DUI")) {
            System.out.print("Invalid type. Enter again: ");
            violationType = scanner.nextLine().toUpperCase();
        }

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
