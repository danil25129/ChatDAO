package chatDAO.datalayer.oracledb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import chatDAO.datalayer.HotelDAO;
import chatDAO.datalayer.data.CountHotelClientsEachMonth;
import chatDAO.datalayer.data.ListClientsCurrentlyResiding;
import chatDAO.datalayer.data.ListSettlementsCertainPeriodTime;
import chatDAO.entities.Clients;
import chatDAO.entities.Rooms;
import chatDAO.entities.Settlement;
import chatDAO.printTable.TableFormatterOutput;

public class OracleHotelDAO implements HotelDAO {
	
	private Connection connection;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	public OracleHotelDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	@Override
	public List<ListSettlementsCertainPeriodTime> getListSettlementsCertainPeriodTime() {
		
		List<ListSettlementsCertainPeriodTime> settlements = new ArrayList<>();
		String query = TableFormatterOutput.getResourcer().getString("sqlQuerie1");
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Settlement settlement = new Settlement(resultSet.getInt("SETTLEMENT_CODE"),
						resultSet.getInt("CLIENTS_CODE1"), resultSet.getInt("ROOM_CODE1"),
						resultSet.getString("DATE_OF_SETTLEMENT"), resultSet.getString("DATE_RELEASE"),
						resultSet.getString("NOTE"));
				Clients client = new Clients(resultSet.getInt("CLIENTS_CODE"),
						resultSet.getString("FAMILY"), resultSet.getString("NAME_"),
						resultSet.getString("PATRONYMIC"), resultSet.getString("PASSPORT_DATA"),
						resultSet.getString("COMMENT_"));
				Rooms room = new Rooms(resultSet.getInt("ROOM_CODE"),
						resultSet.getInt("NUMBER_"), resultSet.getInt("NUMBER_OF_PEAPLE"),
						resultSet.getString("COMFORT"), resultSet.getInt("PRICE"));
				
				ListSettlementsCertainPeriodTime settlementAdd = 
						new ListSettlementsCertainPeriodTime(client, room, settlement);
				settlements.add(settlementAdd);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return settlements;
	}
	
	@Override
	public List<ListClientsCurrentlyResiding> getListClientsCurrentlyResiding() {
		
		List<ListClientsCurrentlyResiding> clients = new ArrayList<>();
		String query = TableFormatterOutput.getResourcer().getString("sqlQuerie2");
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Settlement settlement = new Settlement(resultSet.getInt("SETTLEMENT_CODE"),
						resultSet.getInt("CLIENTS_CODE1"), resultSet.getInt("ROOM_CODE1"),
						resultSet.getString("DATE_OF_SETTLEMENT"), resultSet.getString("DATE_RELEASE"),
						resultSet.getString("NOTE"));
				Clients client = new Clients(resultSet.getInt("CLIENTS_CODE"),
						resultSet.getString("FAMILY"), resultSet.getString("NAME_"),
						resultSet.getString("PATRONYMIC"), resultSet.getString("PASSPORT_DATA"),
						resultSet.getString("COMMENT_"));
				
				ListClientsCurrentlyResiding clientAdd = 
						new ListClientsCurrentlyResiding(client, settlement);
				clients.add(clientAdd);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return clients;
	}
	
	@Override
	public List<CountHotelClientsEachMonth> getCountHotelClientsEachMonth() {
		
		List<CountHotelClientsEachMonth> clientsCountMonth = new ArrayList<>();
		String query = TableFormatterOutput.getResourcer().getString("sqlQuerie3");
		
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				CountHotelClientsEachMonth client = new CountHotelClientsEachMonth(resultSet.getString("MONTH"),
						resultSet.getInt("COUNT_OF_CLIENTS"));
				clientsCountMonth.add(client);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return clientsCountMonth;
	}
	

}
