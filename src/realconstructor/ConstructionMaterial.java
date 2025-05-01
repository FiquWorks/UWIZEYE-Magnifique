package realconstructor;

import java.util.Objects;

public abstract class ConstructionMaterial {
    protected final String contractorId;
    protected final String contractorName;
    protected double materialQuantity;
    protected double materialBalance;

    public ConstructionMaterial(String contractorId, String contractorName, 
                              double materialQuantity, double materialBalance) {
        this.contractorId = validateContractorId(contractorId);
        this.contractorName = validateContractorName(contractorName);
        this.materialQuantity = validateMaterialQuantity(materialQuantity);
        this.materialBalance = validateMaterialBalance(materialBalance);
    }

    private String validateContractorId(String id) {
        Objects.requireNonNull(id, "Contractor ID cannot be null");
        if (!id.matches("^[A-Z]{2}\\d{6}$")) {
            throw new IllegalArgumentException("Contractor ID must be in format AA123456 (2 letters + 6 digits)");
        }
        return id;
    }

    private String validateContractorName(String name) {
        Objects.requireNonNull(name, "Contractor name cannot be null");
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Contractor name cannot be empty");
        }
        if (!name.matches("^[a-zA-Z ]{2,50}$")) {
            throw new IllegalArgumentException("Name must be 2-50 alphabetic characters");
        }
        return name.trim();
    }

    private double validateMaterialQuantity(double quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Material quantity cannot be negative");
        }
        return quantity;
    }

    private double validateMaterialBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Material balance cannot be negative");
        }
        return balance;
    }

    public abstract void receiveMaterial(double quantity);
    public abstract void useMaterial(double quantity);
    public abstract void estimateCost(double quantityUsed);

    public final String getContractorId() { return contractorId; }
    public final String getContractorName() { return contractorName; }
    public final double getMaterialQuantity() { return materialQuantity; }
    public final double getMaterialBalance() { return materialBalance; }
}