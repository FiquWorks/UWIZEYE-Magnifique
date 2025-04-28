package trafficfinesystem;

public class FinePayment extends TrafficRecord {

    @Override
    public void processPayment() {
        System.out.println("\n--- Payment Section ---");
        if (paymentStatus.equals("PAID")) {
            System.out.println("Error: Fine is already paid.");
        } else {
            paymentStatus = "PAID";
            System.out.println("Payment successful! Here is your receipt:");
            System.out.println("Driver: " + driverName);
            System.out.println("Plate: " + vehiclePlate);
            System.out.println("Paid Amount: " + fineAmount + " RWF");
            System.out.println("Payment Status: " + paymentStatus + "\n");
        }
    }

    @Override
    public void assessFine() {}

    @Override
    public void recordViolation() {}
}
