package chatDAO.datalayer.data;

import chatDAO.entities.Clients;
import chatDAO.entities.Rooms;
import chatDAO.entities.Settlement;

public class ListSettlementsCertainPeriodTime {
	
	private Clients clients;
	private Rooms rooms;
	private Settlement settlement;
	
	public ListSettlementsCertainPeriodTime(Clients clients, Rooms rooms, Settlement settlement) {
		this.clients = clients;
		this.rooms = rooms;
		this.settlement = settlement;
	}

	public Clients getClients() {
		return clients;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public Settlement getSettlement() {
		return settlement;
	}
	
	
	
	

}
