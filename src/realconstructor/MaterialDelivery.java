package realconstructor;

public class MaterialDelivery extends ConstructionMaterial {

    public MaterialDelivery(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial(double quantity) {
        materialBalance += quantity;
        System.out.printf(" Material Delivered: %.1f tons added to stock.%n", quantity);
        System.out.printf(" Current Material Balance: %.1f tons%n", materialBalance);
    }

    @Override
    public void useMaterial(double quantity) {
    }

    @Override
    public void estimateCost(double quantityUsed) {
    }
}
