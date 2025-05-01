package realconstructor;

import java.text.NumberFormat;
import java.util.Locale;

public class CostEstimation extends ConstructionMaterial {
    private static final double BULK_THRESHOLD = 15.0;
    private static final double REGULAR_RATE = 200_000;
    private static final double BULK_RATE = 180_000;

    public CostEstimation(String contractorId, String contractorName, 
                        double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial(double quantity) {
        throw new UnsupportedOperationException("CostEstimation cannot receive materials");
    }

    @Override
    public void useMaterial(double quantity) {
        throw new UnsupportedOperationException("CostEstimation cannot use materials");
    }

    @Override
    public void estimateCost(double quantityUsed) {
        if (quantityUsed <= 0) {
            throw new IllegalArgumentException("Quantity used must be positive");
        }
        
        double rate = quantityUsed > BULK_THRESHOLD ? BULK_RATE : REGULAR_RATE;
        double totalCost = quantityUsed * rate;
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));
        fmt.setMaximumFractionDigits(2);
        
        System.out.println("\n=== COST ESTIMATION REPORT ===");
        System.out.println("Contractor: " + contractorName + " (" + contractorId + ")");
        System.out.printf("Material Used: %.2f tons%n", quantityUsed);
        System.out.printf("Rate Applied: %, .2f RWF/ton%n", rate);
        System.out.printf("TOTAL COST: %s%n", fmt.format(totalCost));
    }
}