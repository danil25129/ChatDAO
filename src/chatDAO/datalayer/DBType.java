package chatDAO.datalayer;

import java.sql.SQLException;

import chatDAO.datalayer.oracledb.OracleDAOFactoryDB;
import chatDAO.datalayer.xml.DAOFactoryXML;

public enum DBType {
	XML {
		@Override
		public DAOFactory getDAOFactory() {
			DAOFactory xmlDAOFactory = new DAOFactoryXML();
			return xmlDAOFactory;
		}
	},
	ORACLE {
		@Override
		public DAOFactory getDAOFactory() {
			DAOFactory oracleDAOFactoryDB = null;
			try {
				oracleDAOFactoryDB = OracleDAOFactoryDB.getInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return oracleDAOFactoryDB;
		}
	};

	public static DBType getTypeByName(String dbType) {
		try {
			return DBType.valueOf(dbType.toUpperCase());
		} catch (Exception e) {
			throw new DBTypeException();
		}
	}

	public abstract DAOFactory getDAOFactory();

}
