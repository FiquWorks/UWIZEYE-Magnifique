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
        if ((materialBalance - quantity) >= 2) {
            materialBalance -= quantity;
            System.out.printf(" Material Used: %.1f tons%n", quantity);
            System.out.printf(" Remaining Material Balance: %.1f tons%n", materialBalance);
        } else {
            System.out.println(" Insufficient material. Must maintain at least 2 tons in stock.");
        }
    }

    @Override
    public void estimateCost(double quantityUsed) {
        // Not used here
    }
}
