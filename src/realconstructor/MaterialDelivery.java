package realconstructor;

public class MaterialDelivery extends ConstructionMaterial {

    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial(double quantity) {
        if (quantity >= 1 && quantity <= 10) {
            materialBalance += quantity;
            System.out.printf(" Material Delivered: %.1f tons successfully added to stock.%n", quantity);
            System.out.printf(" Current Material Balance: %.1f tons%n", materialBalance);
        } else {
            System.out.println(" Delivery failed. Quantity must be between 1 and 10 tons.");
        }
    }

    @Override
    public void useMaterial(double quantity) {
        
    }

    @Override
    public void estimateCost(double quantityUsed) {
        
    }
}
