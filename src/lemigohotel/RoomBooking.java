package lemigohotel;

public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void bookRoom() {
        if (!"AVAILABLE".equals(roomStatus)) {
            throw new IllegalStateException("Cannot book room - current status: " + roomStatus);
        }
        
        roomStatus = "OCCUPIED";
        System.out.println("\n✅ Booking Confirmation");
        System.out.println("----------------------");
        System.out.println("Guest: " + guestName + " (" + guestId + ")");
        System.out.println("Room Type: " + roomType);
        System.out.println("Duration: " + stayDays + " nights");
        System.out.println("Status: " + roomStatus);
    }

    @Override
    public void checkoutGuest() {
        throw new UnsupportedOperationException("RoomBooking cannot process checkouts");
    }

    @Override
    public void generateBill() {
        throw new UnsupportedOperationException("RoomBooking cannot generate bills");
    }
}