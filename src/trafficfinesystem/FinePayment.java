package trafficfinesystem;

public class FinePayment extends TrafficRecord {

    @Override
    public void processPayment() {
        System.out.println("\n--- Payment Section ---");

        if (fineAmount <= 0) {
            System.out.println("[Error] Fine amount is not set. Cannot proceed with payment.");
            return;
        }

        if ("PAID".equalsIgnoreCase(paymentStatus)) {
            System.out.println("[Info] Payment already completed.");
            return;
        }

        paymentStatus = "PAID";

        System.out.println("Payment successful. Receipt:");
        System.out.println("Driver: " + driverName);
        System.out.println("Plate: " + vehiclePlate);
        System.out.println("Amount Paid: " + fineAmount + " RWF");
        System.out.println("Status: " + paymentStatus + "\n");
    }

    @Override
    public void assessFine() {}

    @Override
    public void recordViolation() {}
}
