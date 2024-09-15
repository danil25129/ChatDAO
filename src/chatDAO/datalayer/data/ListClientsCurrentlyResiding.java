package chatDAO.datalayer.data;

import chatDAO.entities.Clients;
import chatDAO.entities.Settlement;

public class ListClientsCurrentlyResiding {
	
	private Clients clients;
	private Settlement settlement;
	
	public ListClientsCurrentlyResiding(Clients clients, Settlement settlement) {
		this.clients = clients;
		this.settlement = settlement;
	}

	public Clients getClients() {
		return clients;
	}

	public Settlement getSettlement() {
		return settlement;
	}
	

}
