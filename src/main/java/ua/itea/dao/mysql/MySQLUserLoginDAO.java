package ua.itea.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ua.itea.dao.LoginUserDAO;
import ua.itea.model.User;

public class MySQLUserLoginDAO implements LoginUserDAO {
	private MySQLFactoryDao factory;
	private static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM `user` WHERE login=? AND password=?";

	public MySQLUserLoginDAO(MySQLFactoryDao factory) {
		this.factory = factory;
	}

	@Override
	public User getUserByLoginAndPassword(String login, String password) {
		User user = null;

		Connection conn = factory.creatConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(GET_USER_BY_LOGIN_AND_PASSWORD);
			st.setString(1, login);
			st.setString(2, password);
			rs = st.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setComment(rs.getString("comment"));
				user.setAddress(rs.getString("address"));
				user.setGender(rs.getString("gender"));
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

		return user;
	}

}
