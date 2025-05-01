package lemigohotel;

import java.util.Scanner;

public class HotelMain {

    
    public static void run(Scanner scanner) {
        try {
            System.out.println("🏨 LEMIGO HOTEL MANAGEMENT SYSTEM");
            System.out.println("--------------------------------");

            
            System.out.println("\n=== NEW BOOKING ===");
            RoomBooking booking = createBooking(scanner);
            booking.bookRoom();

            
            System.out.println("\n=== GUEST CHECKOUT ===");
            GuestCheckout checkout = createCheckout(scanner);
            checkout.checkoutGuest();

            
            System.out.println("\n=== GENERATE BILL ===");
            Billing billing = createBilling(scanner);
            billing.generateBill();

        } catch (Exception e) {
            System.err.println("\n⚠️ Error: " + e.getMessage());
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    
    private static RoomBooking createBooking(Scanner scanner) {
        String guestId = promptForInput(scanner, "Enter Guest ID (format AB1234): ",
                "^[A-Z]{2}\\d{4}$", "Invalid format. Must be 2 letters followed by 4 digits");

        String guestName = promptForInput(scanner, "Enter Guest Name: ",
                "^[a-zA-Z ]{2,50}$", "Name must be 2-50 alphabetic characters");

        String roomType = promptForInput(scanner, "Enter Room Type (STANDARD/DELUXE/SUITE): ",
                "STANDARD|DELUXE|SUITE", "Invalid room type");

        int stayDays = promptForInt(scanner, "Enter Stay Duration (1-30 days): ", 1, 30);

        return new RoomBooking(guestId, guestName, roomType, stayDays);
    }

    private static GuestCheckout createCheckout(Scanner scanner) {
        String guestId = promptForInput(scanner, "Enter Guest ID to checkout: ",
                "^[A-Z]{2}\\d{4}$", "Invalid guest ID format");

        String guestName = promptForInput(scanner, "Confirm Guest Name: ",
                "^[a-zA-Z ]{2,50}$", "Invalid guest name");

        return new GuestCheckout(guestId, guestName);
    }

    private static Billing createBilling(Scanner scanner) {
        String guestId = promptForInput(scanner, "Enter Guest ID for billing: ",
                "^[A-Z]{2}\\d{4}$", "Invalid guest ID format");

        String guestName = promptForInput(scanner, "Confirm Guest Name: ",
                "^[a-zA-Z ]{2,50}$", "Invalid guest name");

        String roomType = promptForInput(scanner, "Enter Room Type (STANDARD/DELUXE/SUITE): ",
                "STANDARD|DELUXE|SUITE", "Invalid room type");

        int stayDays = promptForInt(scanner, "Enter Stay Duration (1-30 days): ", 1, 30);

        return new Billing(guestId, guestName, roomType, stayDays);
    }

    private static String promptForInput(Scanner scanner, String prompt,
                                         String regex, String errorMsg) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.matches(regex)) {
                return input;
            }
            System.out.println("❌ " + errorMsg);
        }
    }

    private static int promptForInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.printf("❌ Value must be between %d and %d%n", min, max);
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number");
            }
        }
    }
}
