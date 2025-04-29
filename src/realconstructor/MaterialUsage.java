package realconstructor;

public class MaterialUsage extends ConstructionMaterial {

    public MaterialUsage(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        super(contractorId, contractorName, materialQuantity, materialBalance);
    }

    @Override
    public void receiveMaterial(double quantity) {
    }

    @Override
    public void useMaterial(double quantity) {
        materialBalance -= quantity;
        System.out.printf(" Material Used: %.1f tons%n", quantity);
        System.out.printf(" Remaining Material Balance: %.1f tons%n", materialBalance);
    }

    @Override
    public void estimateCost(double quantityUsed) {
    }
}
