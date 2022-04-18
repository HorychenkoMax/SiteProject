package ua.itea.service;

import ua.itea.dao.FactoryDao;
import ua.itea.dao.LoginUserDAO;
import ua.itea.model.User;

public class LoginUserService implements LoginUserDAO {
	FactoryDao factory;
	LoginUserDAO loginUser;

	public LoginUserService() {
		factory = FactoryDao.newInstance();
		loginUser = factory.getLoginUserDAO();
	}

	@Override
	public User getUserByLoginAndPassword(String login, String password) {
		return loginUser.getUserByLoginAndPassword(login, password);
	}

}
