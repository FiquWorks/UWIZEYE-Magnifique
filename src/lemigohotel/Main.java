package lemigohotel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guestId = "";
        while (true) {
            System.out.print("Enter Guest ID (numeric only): ");
            guestId = scanner.nextLine();
            if (guestId.matches("[0-9]+")) break;
            System.out.println("Invalid ID! Please enter a numeric Guest ID.");
        }

        String guestName = "";
        while (true) {
            System.out.print("Enter Guest Name: ");
            guestName = scanner.nextLine();
            if (guestName.isEmpty()) {
                System.out.println("Guest name cannot be empty! Please enter a valid name.");
            } else if (!guestName.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid name! Please enter a valid name (alphabetic characters only).");
            } else {
                break;
            }
        }

        String roomType = "";
        while (true) {
            System.out.print("Enter Room Type (STANDARD, DELUXE, SUITE): ");
            roomType = scanner.nextLine().toUpperCase();
            if (roomType.equals("STANDARD") || roomType.equals("DELUXE") || roomType.equals("SUITE")) break;
            System.out.println("Invalid room type! Please enter a valid option (STANDARD, DELUXE, SUITE).");
        }

        int stayDays = 0;
        while (true) {
            System.out.print("Enter Stay Duration (in days): ");
            try {
                stayDays = scanner.nextInt();
                if (stayDays >= 1 && stayDays <= 30) break;
                System.out.println("Stay duration must be between 1 and 30 days.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number for the stay duration.");
                scanner.next();
            }
        }

        RoomBooking roomBooking = new RoomBooking(guestId, guestName, roomType, stayDays);
        roomBooking.bookRoom();

        GuestCheckout guestCheckout = new GuestCheckout(guestId, guestName, roomType, stayDays);
        guestCheckout.checkoutGuest();

        Billing billing = new Billing(guestId, guestName, roomType, stayDays);
        billing.generateBill();

        scanner.close();
    }
}
