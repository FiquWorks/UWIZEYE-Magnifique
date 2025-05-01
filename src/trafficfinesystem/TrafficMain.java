package trafficfinesystem;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TrafficMain {
    public static void run(Scanner scanner) {
        System.out.println("\n=== Traffic Fine System ===");

        
        String id;
        while (true) {
            System.out.print("Driver National ID (16 digits): ");
            id = scanner.nextLine().trim();
            if (id.matches("\\d{16}")) {
                break;
            }
            System.out.println("[Error] National ID must be exactly 16 digits.");
        }

        
        String name;
        while (true) {
            System.out.print("Driver Name: ");
            name = scanner.nextLine().trim();
            if (name.matches("[a-zA-Z ]{2,}")) {
                break;
            }
            System.out.println("[Error] Name must contain only letters and spaces (minimum 2 characters).");
        }

        
        String plate;
        Pattern platePattern = Pattern.compile("^R[A-Z]{2}\\d{3}[A-Z]$");
        while (true) {
            System.out.print("Vehicle Plate (e.g., RAB123D): ");
            plate = scanner.nextLine().trim().toUpperCase();
            if (platePattern.matcher(plate).matches()) {
                break;
            }
            System.out.println("[Error] Plate must be in format RAB123D (3 letters, 3 numbers, 1 letter).");
        }

        
        String violation;
        while (true) {
            System.out.print("Violation Type (SPEEDING, RED_LIGHT, NO_HELMET, DUI): ");
            violation = scanner.nextLine().trim().toUpperCase();
            if (violation.matches("SPEEDING|RED_LIGHT|NO_HELMET|DUI")) {
                break;
            }
            System.out.println("[Error] Invalid violation type. Choose from: SPEEDING, RED_LIGHT, NO_HELMET, DUI");
        }

        double fine = 0;
        switch (violation) {
            case "SPEEDING":
                fine = 50000;
                break;
            case "RED_LIGHT":
                fine = 80000;
                break;
            case "NO_HELMET":
                fine = 30000;
                break;
            case "DUI":
                fine = 150000;
                break;
        }

        System.out.println("\n--- Violation Recorded ---");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Plate: " + plate);
        System.out.println("Violation: " + violation);
        System.out.println("Status: UNPAID\n");

        System.out.println("--- Fine Assessed ---");
        System.out.println("Driver: " + name);
        System.out.println("Violation: " + violation);
        System.out.println("Fine Amount: " + fine + " RWF\n");

        System.out.println("--- Payment Section ---");
        System.out.println("Payment successful. Receipt:");
        System.out.println("Driver: " + name);
        System.out.println("Plate: " + plate);
        System.out.println("Amount Paid: " + fine + " RWF");
        System.out.println("Status: PAID");
    }
}