package chatDAO.printTable;

import java.util.List;

import com.resourcer.ProjectResourcer;
import com.resourcer.Resourcer;

import chatDAO.datalayer.data.CountHotelClientsEachMonth;
import chatDAO.datalayer.data.ListClientsCurrentlyResiding;
import chatDAO.datalayer.data.ListSettlementsCertainPeriodTime;

public class TableFormatterOutput {
	
	private TableFormatterOutput() {
		
	}
	
	private static Resourcer resourcer = ProjectResourcer.getInstance();

	
	public static String printResultQuerieOne(List<ListSettlementsCertainPeriodTime> settlements) {
		StringBuilder result = new StringBuilder();
		result.append(resourcer.getString("tire")).append(resourcer.getString("/n"));
		result.append(String.format(resourcer.getString("format"), resourcer.getString("stick"), 
				resourcer.getString("settlement"), resourcer.getString("stick"), 
				resourcer.getString("family"), resourcer.getString("stick"), 
				resourcer.getString("number"), resourcer.getString("stick"),
				resourcer.getString("dateSettlement"), resourcer.getString("stick"),
				resourcer.getString("dateRelease"), resourcer.getString("stick")));
		result.append(resourcer.getString("/n"));
		result.append(resourcer.getString("tire")).append(resourcer.getString("/n"));
		for (ListSettlementsCertainPeriodTime settle : settlements) {
			result.append(String.format(resourcer.getString("format"), resourcer.getString("stick"),
				 settle.getSettlement().getSettlementCode(), resourcer.getString("stick"), settle.getClients().getFamily(), 
				 resourcer.getString("stick"), settle.getRooms().getNumber(), resourcer.getString("stick"), 
				 settle.getSettlement().getDateSettlement(), resourcer.getString("stick"), settle.getSettlement().getDateRelease(),
				 resourcer.getString("stick")));
			result.append(resourcer.getString("/n"));
	 }
		result.append(resourcer.getString("tire"));
		return result.toString();
	}
	
	public static String printResultQuerieSecond(List<ListClientsCurrentlyResiding> clients) {
		StringBuilder result = new StringBuilder();
		result.append(resourcer.getString("tire2")).append(resourcer.getString("/n"));
		result.append(String.format(resourcer.getString("format2"), resourcer.getString("stick"), 
				resourcer.getString("clientCode"), resourcer.getString("stick"), 
				resourcer.getString("family"), resourcer.getString("stick")));
		result.append(resourcer.getString("/n"));
		result.append(resourcer.getString("tire2")).append(resourcer.getString("/n"));
		for (ListClientsCurrentlyResiding current : clients) {
			result.append(String.format(resourcer.getString("format2"), resourcer.getString("stick"),
				 current.getClients().getClientsCode(), resourcer.getString("stick"), current.getClients().getFamily(),
				 resourcer.getString("stick")));
			result.append(resourcer.getString("/n"));
	 }
		result.append(resourcer.getString("tire2"));
		return result.toString();
	}
	
	public static String printResultQuerieThird(List<CountHotelClientsEachMonth> clientsCountMonth) {
		StringBuilder result = new StringBuilder();
		result.append(resourcer.getString("tire3")).append(resourcer.getString("/n"));
		result.append(String.format(resourcer.getString("format3"), resourcer.getString("stick"), 
				resourcer.getString("month"), resourcer.getString("stick"), 
				resourcer.getString("countClient"), resourcer.getString("stick")));
		result.append(resourcer.getString("/n"));
		result.append(resourcer.getString("tire3")).append(resourcer.getString("/n"));
		for (CountHotelClientsEachMonth clientCount : clientsCountMonth) {
			result.append(String.format(resourcer.getString("format3"), resourcer.getString("stick"),
				 clientCount.getMonth(), resourcer.getString("stick"), clientCount.getClientCount(),
				 resourcer.getString("stick")));
			result.append(resourcer.getString("/n"));
	 }
		result.append(resourcer.getString("tire3"));
		return result.toString();
	}
	
	
	public static Resourcer getResourcer() {
		return resourcer;
	}
	
	
	

}
