package chatDAO.datalayer.oracledb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

import chatDAO.datalayer.DAOFactory;
import chatDAO.datalayer.HotelDAO;
import chatDAO.printTable.TableFormatterOutput;


public class OracleDAOFactoryDB extends DAOFactory {
	
	private static volatile OracleDAOFactoryDB instance;
	private Connection connection;

	private OracleDAOFactoryDB() {
	}

	public static OracleDAOFactoryDB getInstance()
			throws ClassNotFoundException, SQLException {
		OracleDAOFactoryDB factory = instance;
		if (instance == null) {
			synchronized (OracleDAOFactoryDB.class) {
				factory = new OracleDAOFactoryDB();
				instance = factory;
				factory.connected();
			}
		}
		return factory;
	}

	private void connected() throws ClassNotFoundException, SQLException {
		Locale.setDefault(Locale.ENGLISH);
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = TableFormatterOutput.getResourcer().getString("url");
		String user = TableFormatterOutput.getResourcer().getString("userName");
		String password = TableFormatterOutput.getResourcer().getString("password");
		connection = DriverManager.getConnection(url, user, password);
		System.out.println(TableFormatterOutput.getResourcer().getString("successfulConnect"));
	}

	@Override
	public HotelDAO getHotelDAO() {
		OracleHotelDAO hotelDAO = new OracleHotelDAO(connection);
		return hotelDAO;
	}


}
