package realconstructor;

import java.text.NumberFormat;
import java.util.Locale;

public class CostEstimation extends ConstructionMaterial {

    public CostEstimation(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial(double quantity) {
        
    }

    @Override
    public void useMaterial(double quantity) {
        
    }

    @Override
    public void estimateCost(double quantityUsed) {
        int costPerTon = (quantityUsed > 15) ? 180000 : 200000;
        double totalCost = quantityUsed * costPerTon;

        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));
        formatter.setMaximumFractionDigits(2);

        System.out.println("\n=== Cost Estimation ===");
        System.out.println("Contractor ID: " + contractorId);
        System.out.println("Contractor Name: " + contractorName);
        System.out.printf("Material Quantity Used: %.1f tons%n", quantityUsed);
        System.out.printf("✅ Total Cost:  %, .2f RWF%n", totalCost);
    }
}
