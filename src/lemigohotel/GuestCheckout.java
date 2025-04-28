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
            System.out.println("Guest " + guestName + " has successfully checked out.");
        } else {
            System.out.println("Room is already available. No checkout needed.");
        }
    }

    @Override
    public void bookRoom() {}
    @Override
    public void generateBill() {}
}
