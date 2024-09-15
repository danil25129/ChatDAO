package chatDAO.datalayer.data;

public class CountHotelClientsEachMonth {
	
	private String month;
	private int clientCount;
	
	public CountHotelClientsEachMonth(String month, int clientCount) {
		this.month = month;
		this.clientCount = clientCount;
	}

	public String getMonth() {
		return month;
	}

	public int getClientCount() {
		return clientCount;
	}
	
	
}
