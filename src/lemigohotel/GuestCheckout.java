package lemigohotel;

public class GuestCheckout extends HotelService {
    public GuestCheckout(String guestId, String guestName) {
        super(guestId, guestName);
    }

    @Override
    public void checkoutGuest() {
        if (!"OCCUPIED".equals(roomStatus)) {
            throw new IllegalStateException("Cannot checkout - room is not occupied");
        }
        
        roomStatus = "AVAILABLE";
        System.out.println("\n✅ Checkout Complete");
        System.out.println("------------------");
        System.out.println("Guest: " + guestName + " (" + guestId + ")");
        System.out.println("Status: " + roomStatus);
    }

    @Override
    public void bookRoom() {
        throw new UnsupportedOperationException("GuestCheckout cannot book rooms");
    }

    @Override
    public void generateBill() {
        throw new UnsupportedOperationException("GuestCheckout cannot generate bills");
    }
}