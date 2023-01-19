package laterClass.hotel;

public class Hotel {
	private String hotelName;
	private Room[] rooms;
	private int totalRooms;
	private int totalFloors;
	
	public Hotel(String newHotelName, int newTotalRooms, int newTotalFloors) {
		hotelName = newHotelName;
		totalRooms = newTotalRooms;
		totalFloors = newTotalFloors;
		rooms = new Room[totalRooms];
		
		generateRooms();
	}
	
	//generating hotel rooms
	public void generateRooms() {
		int roomsPerFloor = totalRooms / totalFloors;
		int suiteNumber = 0;
		int singleKingNumber = 0;
		
		for (int currFloor = 1; currFloor <= totalFloors; currFloor++) {
			for (int i = roomsPerFloor - 1; i >= 0; i--) {
				if (suiteNumber == 0) {
					rooms[i + (currFloor - 1) * roomsPerFloor] = new Room(currFloor * 100 + i, "suite");
					suiteNumber++;
				}
				else if (singleKingNumber < 4) {
					rooms[i + (currFloor - 1) * roomsPerFloor] = new Room(currFloor * 100 + i, "single king");
					singleKingNumber++;
				}
				else {
					rooms[i + (currFloor - 1) * roomsPerFloor] = new Room(currFloor * 100 + i, "double queen");
				}
			}
		}
	}
	
	//getters
	public int getNumberOccupied() {
		int count = 0;
		
		for (Room room : rooms) {
			if (room.getDaysRented() > 0) {
				count++;
			}
		}
		return count;
	}
	
	public double getOccupancyRate() {
		return Math.round((getNumberOccupied() / ((double) totalRooms) * 100));
	}
	
	//setters
	public boolean rentRoom(String setRoomType, String setOccupantName, int setDaysRented) {
		for (Room room : rooms) {
			if (setRoomType == room.getRoomType() && room.getDaysRented() == 0) {
				room.setOccupant(setOccupantName, setDaysRented);
				return true;
			}
		}
		return false;
	}
	
	//methods
	public void advanceDay() {
		for (Room room : rooms) {
			if (room.getDaysRented() > 0) {
				room.advanceDay();;
			}
		}
	}
	
	public String toString() {
		return hotelName + ": " + (int) (getOccupancyRate()) + "% occupied";
	}
	
	public void printRooms() {
		for (Room room : rooms) {
			if (room.getDaysRented() > 0) {
				System.out.println("Room " + room.getRoomNumber() + ": " + room.getRoomType() + " - rented to " + room.getOccupantName());
			}
			else {
				System.out.println("Room " + room.getRoomNumber() + ": " + room.getRoomType() + " - free");
			}
		}
	}
}