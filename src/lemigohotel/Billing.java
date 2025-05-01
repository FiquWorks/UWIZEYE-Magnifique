package lemigohotel;

import java.text.NumberFormat;
import java.util.Locale;

public class Billing extends HotelService {
    private static final int STANDARD_RATE = 50000;
    private static final int DELUXE_RATE = 80000;
    private static final int SUITE_RATE = 120000;

    public Billing(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void generateBill() {
        int rate = switch (roomType) {
            case "STANDARD" -> STANDARD_RATE;
            case "DELUXE" -> DELUXE_RATE;
            case "SUITE" -> SUITE_RATE;
            default -> throw new IllegalStateException("Invalid room type: " + roomType);
        };

        int total = rate * stayDays;
        NumberFormat fmt = NumberFormat.getCurrencyInstance(new Locale("en", "RW"));
        fmt.setMaximumFractionDigits(0);

        System.out.println("\n💵 Billing Statement");
        System.out.println("------------------");
        System.out.println("Guest: " + guestName + " (" + guestId + ")");
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + stayDays);
        System.out.println("Rate: " + fmt.format(rate) + "/night");
        System.out.println("------------------");
        System.out.println("TOTAL: " + fmt.format(total));
    }

    @Override
    public void bookRoom() {
        throw new UnsupportedOperationException("Billing cannot book rooms");
    }

    @Override
    public void checkoutGuest() {
        throw new UnsupportedOperationException("Billing cannot process checkouts");
    }
}