package lemigohotel;

public class GuestCheckout extends HotelService {
    public GuestCheckout(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
        this.roomStatus = "OCCUPIED";
    }

    @Override
    public void checkoutGuest() {
        if (roomStatus.equals("OCCUPIED")) {
            roomStatus = "AVAILABLE";
            System.out.println("✅ Checkout complete for guest: " + guestName);
        } else {
            System.out.println("[Checkout Info] Room was already available.");
        }
    }

    @Override
    public void bookRoom() {}
    @Override
    public void generateBill() {}
}
