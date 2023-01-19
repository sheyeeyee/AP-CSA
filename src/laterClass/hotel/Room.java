package laterClass.hotel;

public class Room {
	private int roomNumber;
	private int daysRented;
	private String roomType;
	private String occupantName;
	
	public Room(int newRoomNumber, String newRoomType) {
		roomNumber = newRoomNumber;
		daysRented = 0;
		
		if (newRoomType != "single king" && newRoomType != "suite") {
			roomType = "double queen";
		}
		else roomType = newRoomType;
		
		occupantName = null;
	}
	
	//getters
	public int getRoomNumber() {
		return roomNumber;
	}
	public int getDaysRented() {
		return daysRented;
	}
	public String getRoomType() {
		return roomType;
	}
	public String getOccupantName() {
		return occupantName;
	}
	
	//setters
	public boolean setOccupant(String newOccupantName, int newDaysRented) {		
		//is the room already rented
		if (daysRented > 1) {
			return false;
		}
		else {
			occupantName = newOccupantName;
			daysRented = newDaysRented;
			
			return true;
		}
	}
	
	//methods
	public void advanceDay() {
		daysRented --;
		
		if (daysRented <= 0) {
			occupantName = null;
			daysRented = 0;
		}
	}
	
	public String toString() {
		if (occupantName == null) {
			return "Room" + roomNumber  + ": " + roomType + " -- free";
		}
		else {
			return "Room" + roomNumber + ": " + roomType + " -- rented to " + occupantName;
		}
	}
}
