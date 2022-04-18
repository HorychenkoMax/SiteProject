package ua.itea.dao;

import ua.itea.dao.mysql.MySQLFactoryDao;

public abstract class FactoryDao {
	public abstract ProductDAO getProductDao();
	public abstract LoginUserDAO getLoginUserDAO();
	public abstract RegistrationUserDAO getRegistrationUserDAO();

	public static FactoryDao newInstance() {
		return new MySQLFactoryDao();
	}
}
