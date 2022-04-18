package ua.itea.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.itea.dao.RegistrationUserDAO;

public class MySQLRegistrationUserDAO implements RegistrationUserDAO {
	private MySQLFactoryDao factory;
	private static final String IS_USER_LOGIN_EXISTS = "SELECT * FROM `user` WHERE login=?";
	private static final String INSERT_USER = "INSERT INTO `user` (`id`, `name`, `login`, `password`, `gender`, `address`, `comment`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";

	public MySQLRegistrationUserDAO(MySQLFactoryDao factory) {
		this.factory = factory;
	}

	@Override
	public boolean isUserLoginExists(String login) {
		Connection conn = factory.creatConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean isUserExists = false;
		try {
			st = conn.prepareStatement(IS_USER_LOGIN_EXISTS);
			st.setString(1, login);
			rs = st.executeQuery();

			if (rs.next()) {
				isUserExists = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return isUserExists;
	}

	@Override
	public void insertUser(String name, String login, String password, String gender, String address, String comment) {
		Connection conn = factory.creatConnection();
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(INSERT_USER);
			st.setString(1, name);
			st.setString(2, login);
			st.setString(3, password);
			st.setString(4, gender);
			st.setString(5, address);
			st.setString(6, comment);
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
