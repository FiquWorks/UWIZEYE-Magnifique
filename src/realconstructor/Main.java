package realconstructor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        String contractorId = "";
        String contractorName = "";
        double deliveredQty = 0;
        double usedQty = 0;
        double materialBalance = 0;

        
        while (true) {
            System.out.print("Enter Contractor ID (numbers only): ");
            contractorId = sc.nextLine();
            if (contractorId.matches("\\d+")) break;
            else System.out.println(" Contractor ID must be numbers only.");
        }

       
        while (true) {
            System.out.print("Enter Contractor Name: ");
            contractorName = sc.nextLine();
            if (contractorName.matches("[a-zA-Z\\s]+") && !contractorName.trim().isEmpty()) break;
            else System.out.println(" Name must contain letters only and cannot be empty.");
        }

        
        while (true) {
            System.out.print("Enter Material Quantity to Deliver (in tons): ");
            try {
                deliveredQty = Double.parseDouble(sc.nextLine());
                MaterialDelivery delivery = new MaterialDelivery(contractorId, contractorName, deliveredQty, materialBalance);
                delivery.receiveMaterial(deliveredQty);
                materialBalance = delivery.getMaterialBalance();
                break;
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
            }
        }

      
        while (true) {
            System.out.print("Enter Material Quantity to Use (in tons): ");
            try {
                usedQty = Double.parseDouble(sc.nextLine());
                MaterialUsage usage = new MaterialUsage(contractorId, contractorName, usedQty, materialBalance);
                usage.useMaterial(usedQty);
                materialBalance = usage.getMaterialBalance();
                break;
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input. Please enter a number.");
            }
        }

        
        CostEstimation cost = new CostEstimation(contractorId, contractorName, usedQty, materialBalance);
        cost.estimateCost(usedQty);

        sc.close();
    }
}
