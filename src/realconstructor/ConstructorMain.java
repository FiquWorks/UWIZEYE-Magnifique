package realconstructor;

import java.util.Scanner;

public class ConstructorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String contractorId;
        String contractorName;
        double deliveredQty;
        double usedQty;
        double materialBalance = 0;

        while (true) {
            System.out.print("Enter Contractor ID (numbers only): ");
            contractorId = sc.nextLine().trim();
            if (contractorId.matches("\\d+")) break;
            System.out.println(" Contractor ID must be numbers only.");
        }

        while (true) {
            System.out.print("Enter Contractor Name: ");
            contractorName = sc.nextLine().trim();
            if (contractorName.matches("[a-zA-Z\\s]+") && !contractorName.isEmpty()) break;
            System.out.println(" Name must contain letters only and cannot be empty.");
        }

        while (true) {
            System.out.print("Enter Material Quantity to Deliver (1-10 tons): ");
            String input = sc.nextLine().trim();
            try {
                deliveredQty = Double.parseDouble(input);
                if (deliveredQty >= 1 && deliveredQty <= 10) {
                    MaterialDelivery delivery = new MaterialDelivery(contractorId, contractorName, deliveredQty, materialBalance);
                    delivery.receiveMaterial(deliveredQty);
                    materialBalance = delivery.getMaterialBalance();
                    break;
                } else {
                    System.out.println(" Quantity must be between 1 and 10 tons.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a valid number.");
            }
        }

        while (true) {
            System.out.print("Enter Material Quantity to Use (leave at least 2 tons): ");
            String input = sc.nextLine().trim();
            try {
                usedQty = Double.parseDouble(input);
                if (usedQty > 0 && (materialBalance - usedQty) >= 2) {
                    MaterialUsage usage = new MaterialUsage(contractorId, contractorName, usedQty, materialBalance);
                    usage.useMaterial(usedQty);
                    materialBalance = usage.getMaterialBalance();
                    break;
                } else {
                    System.out.println(" Not enough material. Must leave at least 2 tons.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a valid number.");
            }
        }

        CostEstimation cost = new CostEstimation(contractorId, contractorName, usedQty, materialBalance);
        cost.estimateCost(usedQty);

        sc.close();
    }
}
