package trafficfinesystem;

public class FinePayment extends TrafficRecord {

    @Override
    public void processPayment() {
        System.out.println("\n--- Payment Section ---");
        if ("PAID".equals(paymentStatus)) {
            System.out.println("Payment already completed.");
        } else {
            paymentStatus = "PAID";
            System.out.println("Payment successful. Receipt:");
            System.out.println("Driver: " + driverName);
            System.out.println("Plate: " + vehiclePlate);
            System.out.println("Amount Paid: " + fineAmount + " RWF");
            System.out.println("Status: " + paymentStatus + "\n");
        }
    }

    @Override
    public void assessFine() {}

    @Override
    public void recordViolation() {}
}
