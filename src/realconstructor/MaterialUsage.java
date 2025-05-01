package realconstructor;

public class MaterialUsage extends ConstructionMaterial {
    private static final double MINIMUM_STOCK = 2.0;

    public MaterialUsage(String contractorId, String contractorName, 
                       double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial(double quantity) {
        throw new UnsupportedOperationException("MaterialUsage cannot receive materials");
    }

    @Override
    public void useMaterial(double quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Usage quantity must be positive");
        }
        
        if (materialBalance - quantity < MINIMUM_STOCK) {
            throw new IllegalStateException(String.format(
                "Insufficient stock. Cannot go below minimum of %.1f tons", MINIMUM_STOCK));
        }
        
        materialQuantity -= quantity;
        materialBalance -= quantity;
        
        System.out.printf("✅ Usage Recorded: %.1f tons consumed%n", quantity);
        System.out.printf("   Remaining Stock: %.1f tons%n", materialBalance);
    }

    @Override
    public void estimateCost(double quantityUsed) {
        throw new UnsupportedOperationException("MaterialUsage cannot estimate costs");
    }
}