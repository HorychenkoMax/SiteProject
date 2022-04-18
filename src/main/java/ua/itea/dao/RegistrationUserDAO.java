package ua.itea.dao;

public interface RegistrationUserDAO {
	boolean isUserLoginExists(String login);

	void insertUser(String name, String login, String password, String gender, String address, String comment);
}
