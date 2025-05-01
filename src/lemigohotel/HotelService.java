package lemigohotel;

import java.util.Objects;

public abstract class HotelService {
    protected final String guestId;
    protected final String guestName;
    protected String roomType;
    protected Integer stayDays;
    protected String roomStatus;

    
    public HotelService(String guestId, String guestName, String roomType, int stayDays) {
        this.guestId = validateGuestId(guestId);
        this.guestName = validateGuestName(guestName);
        this.roomType = validateRoomType(roomType);
        this.stayDays = validateStayDays(stayDays);
        this.roomStatus = "AVAILABLE";
    }

    
    public HotelService(String guestId, String guestName) {
        this.guestId = validateGuestId(guestId);
        this.guestName = validateGuestName(guestName);
        this.roomStatus = "OCCUPIED";
    }

    private String validateGuestId(String id) {
        Objects.requireNonNull(id, "Guest ID cannot be null");
        if (!id.matches("^[A-Z]{2}\\d{4}$")) {
            throw new IllegalArgumentException("Guest ID must be in format AB1234 (2 letters + 4 digits)");
        }
        return id.toUpperCase();
    }

    private String validateGuestName(String name) {
        Objects.requireNonNull(name, "Guest name cannot be null");
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Guest name cannot be empty");
        }
        if (!name.matches("^[a-zA-Z ]{2,50}$")) {
            throw new IllegalArgumentException("Name must be 2-50 alphabetic characters");
        }
        return name.trim();
    }

    private String validateRoomType(String type) {
        Objects.requireNonNull(type, "Room type cannot be null");
        String upperType = type.toUpperCase();
        if (!upperType.matches("STANDARD|DELUXE|SUITE")) {
            throw new IllegalArgumentException("Room type must be STANDARD, DELUXE, or SUITE");
        }
        return upperType;
    }

    private int validateStayDays(int days) {
        if (days < 1 || days > 30) {
            throw new IllegalArgumentException("Stay duration must be between 1 and 30 days");
        }
        return days;
    }

    public abstract void bookRoom();
    public abstract void checkoutGuest();
    public abstract void generateBill();

    
    public final String getGuestId() { return guestId; }
    public final String getGuestName() { return guestName; }
    public final String getRoomType() { return roomType; }
    public final Integer getStayDays() { return stayDays; }
    public final String getRoomStatus() { return roomStatus; }
}