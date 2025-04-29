package trafficfinesystem;

public class FineAssessment extends TrafficRecord {

    @Override
    public void assessFine() {
        switch (violationType.toUpperCase()) {
            case "SPEEDING": fineAmount = 50000; break;
            case "RED_LIGHT": fineAmount = 80000; break;
            case "NO_HELMET": fineAmount = 30000; break;
            case "DUI": fineAmount = 150000; break;
            default:
                System.out.println("Violation not recognized. Fine not calculated.");
                return;
        }

        System.out.println("\n--- Fine Assessed ---");
        System.out.println("Driver: " + driverName);
        System.out.println("Violation: " + violationType);
        System.out.println("Fine Amount: " + fineAmount + " RWF\n");
    }

    @Override
    public void recordViolation() {}

    @Override
    public void processPayment() {}
}
