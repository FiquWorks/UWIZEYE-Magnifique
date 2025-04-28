package trafficfinesystem;

public abstract class TrafficRecord {
    protected String driverId;
    protected String driverName;
    protected String vehiclePlate;
    protected String violationType;
    protected double fineAmount;
    protected String paymentStatus;

    public abstract void recordViolation();
    public abstract void assessFine();
    public abstract void processPayment();
}
