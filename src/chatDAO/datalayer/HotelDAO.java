package chatDAO.datalayer;

import java.util.List;

import chatDAO.datalayer.data.CountHotelClientsEachMonth;
import chatDAO.datalayer.data.ListClientsCurrentlyResiding;
import chatDAO.datalayer.data.ListSettlementsCertainPeriodTime;

public interface HotelDAO {
	
	List<ListSettlementsCertainPeriodTime> getListSettlementsCertainPeriodTime();
	List<ListClientsCurrentlyResiding> getListClientsCurrentlyResiding();
	List<CountHotelClientsEachMonth> getCountHotelClientsEachMonth();
	
}
