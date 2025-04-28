package lemigohotel;

public class RoomBooking extends HotelService {
    public RoomBooking(String guestId, String guestName, String roomType, int stayDays) {
        super(guestId, guestName, roomType, stayDays);
    }

    @Override
    public void bookRoom() {
        if (stayDays < 1 || stayDays > 30) {
            System.out.println("Stay duration must be between 1 and 30 days.");
            return;
        }

        if (roomStatus.equals("AVAILABLE")) {
            roomStatus = "OCCUPIED";
            System.out.println("Room successfully booked for " + guestName + " in a " + roomType + " room for " + stayDays + " days.");
        } else {
            System.out.println("Room is already occupied.");
        }
    }

    @Override
    public void checkoutGuest() {}
    @Override
    public void generateBill() {}
}
