package chatDAO.entities;

public class Settlement {
	
	private int settlementCode;
	private int clientsCode;
	private int roomCode;
	private String dateSettlement;
	private String dateRelease;
	private String note;
	
	public Settlement(int settlementCode, int clientsCode, int roomCode, String dateSettlement, String dateRelease,
			String note) {
		this.settlementCode = settlementCode;
		this.clientsCode = clientsCode;
		this.roomCode = roomCode;
		this.dateSettlement = dateSettlement;
		this.dateRelease = dateRelease;
		this.note = note;
	}

	public int getSettlementCode() {
		return settlementCode;
	}

	public int getClientsCode() {
		return clientsCode;
	}

	public int getRoomCode() {
		return roomCode;
	}

	public String getDateSettlement() {
		return dateSettlement;
	}

	public String getDateRelease() {
		return dateRelease;
	}

	public String getNote() {
		return note;
	}
	
	

}
