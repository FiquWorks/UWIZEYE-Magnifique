package lemigohotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guestId;
        while (true) {
            System.out.print("Please enter Guest ID (numbers only): ");
            guestId = scanner.nextLine().trim();
            if (guestId.matches("\\d+")) break;
            System.out.println("[Error] Guest ID must contain digits only. Try again.");
        }

        String guestName;
        while (true) {
            System.out.print("Enter Guest Name (letters only): ");
            guestName = scanner.nextLine().trim();
            if (guestName.isEmpty()) {
                System.out.println("[Error] Name cannot be left blank. Please provide a valid name.");
            } else if (!guestName.matches("[a-zA-Z ]+")) {
                System.out.println("[Error] Name should only contain letters and spaces.");
            } else {
                break;
            }
        }

        String roomType;
        while (true) {
            System.out.print("Select Room Type (STANDARD / DELUXE / SUITE): ");
            roomType = scanner.nextLine().trim().toUpperCase();
            if (roomType.equals("STANDARD") || roomType.equals("DELUXE") || roomType.equals("SUITE")) break;
            System.out.println("[Error] Invalid room type. Choose either STANDARD, DELUXE, or SUITE.");
        }

        int stayDays;
        while (true) {
            System.out.print("Enter Stay Duration (1 to 30 days): ");
            try {
                stayDays = scanner.nextInt();
                if (stayDays >= 1 && stayDays <= 30) break;
                System.out.println("[Error] Duration must be between 1 and 30 days.");
            } catch (InputMismatchException e) {
                System.out.println("[Error] Invalid input! Please enter a number only.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Service processes
        RoomBooking roomBooking = new RoomBooking(guestId, guestName, roomType, stayDays);
        roomBooking.bookRoom();

        GuestCheckout guestCheckout = new GuestCheckout(guestId, guestName, roomType, stayDays);
        guestCheckout.checkoutGuest();

        Billing billing = new Billing(guestId, guestName, roomType, stayDays);
        billing.generateBill();

        scanner.close();
    }
}
