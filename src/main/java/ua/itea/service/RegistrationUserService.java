package ua.itea.service;

import ua.itea.dao.FactoryDao;
import ua.itea.dao.RegistrationUserDAO;

public class RegistrationUserService implements RegistrationUserDAO{
	FactoryDao factory;
	RegistrationUserDAO registrationUser;
	

	public RegistrationUserService() {
		factory = FactoryDao.newInstance();
		registrationUser = factory.getRegistrationUserDAO();
	}

	@Override
	public boolean isUserLoginExists(String login) {
		return registrationUser.isUserLoginExists(login);
	}

	@Override
	public void insertUser(String name, String login, String password, String gender, String address, String comment) {
		registrationUser.insertUser(name, login, password, gender, address, comment);
	}

}
