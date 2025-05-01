package realconstructor;

public class MaterialDelivery extends ConstructionMaterial {
    private static final double MIN_DELIVERY = 1.0;
    private static final double MAX_DELIVERY = 10.0;

    public MaterialDelivery(String contractorId, String contractorName, 
                          double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial(double quantity) {
        if (quantity < MIN_DELIVERY || quantity > MAX_DELIVERY) {
            throw new IllegalArgumentException(String.format(
                "Delivery must be between %.1f and %.1f tons", MIN_DELIVERY, MAX_DELIVERY));
        }
        
        materialQuantity += quantity;
        materialBalance += quantity;
        
        System.out.printf("✅ Delivery Successful: %.1f tons received%n", quantity);
        System.out.printf("   Updated Stock: %.1f tons%n", materialBalance);
    }

    @Override
    public void useMaterial(double quantity) {
        throw new UnsupportedOperationException("MaterialDelivery cannot use materials");
    }

    @Override
    public void estimateCost(double quantityUsed) {
        throw new UnsupportedOperationException("MaterialDelivery cannot estimate costs");
    }
}