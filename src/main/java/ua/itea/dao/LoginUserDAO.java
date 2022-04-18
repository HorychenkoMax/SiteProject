package ua.itea.dao;

import ua.itea.model.User;

public interface LoginUserDAO {

	User getUserByLoginAndPassword(String login, String password);
}
