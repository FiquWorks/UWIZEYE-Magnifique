package lemigohotel;

public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void bookRoom() {
        if (stayDays < 1 || stayDays > 30) {
            System.out.println("[Booking Error] Stay duration is out of allowed range.");
            return;
        }

        if (roomStatus.equals("AVAILABLE")) {
            roomStatus = "OCCUPIED";
            System.out.println("✅ Booking confirmed for " + guestName + ": " + roomType + " room for " + stayDays + " day(s).");
        } else {
            System.out.println("[Booking Failed] Room is currently not available.");
        }
    }

    @Override
    public void checkoutGuest() {}
    @Override
    public void generateBill() {}
}
