package realconstructor;

import java.util.Scanner;

public class ConstructorMain {
    public static void run(Scanner scanner) {
        System.out.println("=== REAL CONSTRUCTOR MATERIAL MANAGEMENT ===");
        
        try {
            String contractorId = promptForContractorId(scanner);
            String contractorName = promptForContractorName(scanner);
            
            
            MaterialDelivery delivery = new MaterialDelivery(
                contractorId, contractorName, 0, 0);
            double deliveryQty = promptForDelivery(scanner);
            delivery.receiveMaterial(deliveryQty);
            
            
            MaterialUsage usage = new MaterialUsage(
                contractorId, contractorName, 
                delivery.getMaterialQuantity(), 
                delivery.getMaterialBalance());
            double usageQty = promptForUsage(scanner, usage.getMaterialBalance());
            usage.useMaterial(usageQty);
            
            
            CostEstimation cost = new CostEstimation(
                contractorId, contractorName, 
                usage.getMaterialQuantity(), 
                usage.getMaterialBalance());
            cost.estimateCost(usageQty);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("System Error: " + e.getMessage());
        }
    }

    private static String promptForContractorId(Scanner scanner) {
        while (true) {
            System.out.print("Enter Contractor ID (format AA123456): ");
            String input = scanner.nextLine().trim();
            if (input.matches("^[A-Z]{2}\\d{6}$")) {
                return input;
            }
            System.out.println("Invalid format. Must be 2 letters followed by 6 digits");
        }
    }

    private static String promptForContractorName(Scanner scanner) {
        while (true) {
            System.out.print("Enter Contractor Name: ");
            String input = scanner.nextLine().trim();
            if (input.matches("^[a-zA-Z ]{2,50}$")) {
                return input;
            }
            System.out.println("Invalid name. Must be 2-50 alphabetic characters");
        }
    }

    private static double promptForDelivery(Scanner scanner) {
        while (true) {
            System.out.print("Enter delivery quantity (1-10 tons): ");
            try {
                double qty = Double.parseDouble(scanner.nextLine());
                if (qty >= 1.0 && qty <= 10.0) {
                    return qty;
                }
                System.out.println("Quantity must be between 1 and 10 tons");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }
    }

    private static double promptForUsage(Scanner scanner, double currentBalance) {
        while (true) {
            System.out.printf("Enter usage quantity (max %.1f tons): ", currentBalance - 2.0);
            try {
                double qty = Double.parseDouble(scanner.nextLine());
                if (qty > 0 && qty <= currentBalance - 2.0) {
                    return qty;
                }
                System.out.printf("Quantity must be positive and leave at least 2 tons (max %.1f)%n", 
                                currentBalance - 2.0);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format");
            }
        }
    }
}