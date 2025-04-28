package realconstructor;

public abstract class ConstructionMaterial {
    protected String contractorId;
    protected String contractorName;
    protected double materialQuantity; 
    protected double materialBalance;

    public ConstructionMaterial(String contractorId, String contractorName, double materialQuantity, double materialBalance) {
        this.contractorId = contractorId;
        this.contractorName = contractorName;
        this.materialQuantity = materialQuantity;
        this.materialBalance = materialBalance;
    }

    public abstract void receiveMaterial(double quantity);

    public abstract void useMaterial(double quantity);

    public abstract void estimateCost(double quantityUsed);

    // Getters
    public double getMaterialBalance() {
        return materialBalance;
    }

    public String getContractorId() {
        return contractorId;
    }

    public String getContractorName() {
        return contractorName;
    }
}
