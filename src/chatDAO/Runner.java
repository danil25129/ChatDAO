package chatDAO;


import java.util.List;

import chatDAO.datalayer.DAOFactory;
import chatDAO.datalayer.DBType;
import chatDAO.datalayer.DBTypeException;
import chatDAO.datalayer.HotelDAO;
import chatDAO.datalayer.data.CountHotelClientsEachMonth;
import chatDAO.datalayer.data.ListClientsCurrentlyResiding;
import chatDAO.datalayer.data.ListSettlementsCertainPeriodTime;
import chatDAO.printTable.TableFormatterOutput;


public class Runner {

	private Runner() {
		
	}
	public static void main(String[] args) {
		try {
			DAOFactory factory = DAOFactory.getInstance(DBType.ORACLE);
			StringBuilder result = new StringBuilder(TableFormatterOutput.getResourcer().getString("/n"));
			HotelDAO hotelDAO = factory.getHotelDAO();
			List<ListSettlementsCertainPeriodTime> settlements = hotelDAO.getListSettlementsCertainPeriodTime();
			result.append(TableFormatterOutput.getResourcer().getString("description1"));
			result.append(TableFormatterOutput.printResultQuerieOne(settlements));
			result.append(TableFormatterOutput.getResourcer().getString("/n"))
			.append(TableFormatterOutput.getResourcer().getString("/n"));
			
			result.append(TableFormatterOutput.getResourcer().getString("description2"));
			List<ListClientsCurrentlyResiding> clients = hotelDAO.getListClientsCurrentlyResiding();
			result.append(TableFormatterOutput.printResultQuerieSecond(clients));
			result.append(TableFormatterOutput.getResourcer().getString("/n"))
			.append(TableFormatterOutput.getResourcer().getString("/n"));
			
			result.append(TableFormatterOutput.getResourcer().getString("description3"));
			List<CountHotelClientsEachMonth> clientsCount = hotelDAO.getCountHotelClientsEachMonth();
			result.append(TableFormatterOutput.printResultQuerieThird(clientsCount));
			
			System.out.println(result);
		} catch (DBTypeException e) {
			e.printStackTrace();
		}
	}

}
