package chatDAO.entities;

public class Rooms {
	
	private int roomCode;
	private int number;
	private int peopleCount;
	private String typeComfort;
	private int price;
	
	public Rooms(int roomCode, int number, int peopleCount, String typeComfort, int price) {
		this.roomCode = roomCode;
		this.number = number;
		this.peopleCount = peopleCount;
		this.typeComfort = typeComfort;
		this.price = price;
	}

	public int getRoomCode() {
		return roomCode;
	}

	public int getNumber() {
		return number;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public String getTypeComfort() {
		return typeComfort;
	}

	public int getPrice() {
		return price;
	}
	
	
}
