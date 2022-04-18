package ua.itea.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import ua.itea.dao.FactoryDao;
import ua.itea.dao.LoginUserDAO;
import ua.itea.dao.ProductDAO;
import ua.itea.dao.RegistrationUserDAO;

public class MySQLFactoryDao extends FactoryDao {
	Logger logger = Logger.getLogger(MySQLFactoryDao.class.getSimpleName());

	public MySQLFactoryDao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
			logger.info("Can`t load JDBS driver");
		}
	}

	public Connection creatConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/itea?" + "user=root&password=");

		} catch (SQLException ex) {

			logger.info("SQLException: " + ex.getMessage());
			logger.info("SQLState: " + ex.getSQLState());
			logger.info("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}

	@Override
	public ProductDAO getProductDao() {
		return new MySQLProductDAO(this);
	}

	@Override
	public LoginUserDAO getLoginUserDAO() {
		return new MySQLUserLoginDAO(this);
	}

	@Override
	public RegistrationUserDAO getRegistrationUserDAO() {
		return new MySQLRegistrationUserDAO(this);
	}

	

}
