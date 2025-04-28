package lemigohotel;

public class Billing extends HotelService {
    public Billing(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void generateBill() {
        int costPerNight = switch (roomType.toUpperCase()) {
            case "STANDARD" -> 50000;
            case "DELUXE" -> 80000;
            case "SUITE" -> 120000;
            default -> {
                System.out.println("Invalid room type.");
                yield 0;
            }
        };

        if (costPerNight == 0) return;

        int totalCost = costPerNight * stayDays;

        System.out.println("=== Bill ===");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Guest ID: " + guestId);
        System.out.println("Room Type: " + roomType);
        System.out.println("Days Stayed: " + stayDays);
        System.out.println("Total Cost: " + totalCost + " RWF");
    }

    @Override
    public void bookRoom() {}
    @Override
    public void checkoutGuest() {}
}
