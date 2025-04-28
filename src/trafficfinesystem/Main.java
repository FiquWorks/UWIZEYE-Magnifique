package trafficfinesystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ViolationEntry entry = new ViolationEntry();
        entry.recordViolation();

        FineAssessment assessment = new FineAssessment();
        assessment.driverId = entry.driverId;
        assessment.driverName = entry.driverName;
        assessment.vehiclePlate = entry.vehiclePlate;
        assessment.violationType = entry.violationType;
        assessment.paymentStatus = entry.paymentStatus;
        assessment.assessFine();

        FinePayment payment = new FinePayment();
        payment.driverId = assessment.driverId;
        payment.driverName = assessment.driverName;
        payment.vehiclePlate = assessment.vehiclePlate;
        payment.violationType = assessment.violationType;
        payment.fineAmount = assessment.fineAmount;
        payment.paymentStatus = assessment.paymentStatus;
        payment.processPayment();

        scanner.close();
    }
}
