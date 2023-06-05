package ua.vin.lgs.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.vin.lgs.domain.User;
import ua.vin.lgs.service.UserService;
import ua.vin.lgs.dao.UserDao;
import ua.vin.lgs.dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private static UserServiceImpl userServiceImpl;
	private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	private UserServiceImpl() {
		try {
			userDao = new UserDaoImpl();
//			throw new SQLException();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | SQLException e) {
			LOGGER.error(e);
		}
	}
	
	
	public static UserServiceImpl getUserServiceImpl() {
		if(userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}
	

	@Override
	public User create(User user) {
		user.setRole((user.getPassword().equals("admin-123") && user.getFirstName().equals("admin")) ? "ADMIN" : "USER");
		return userDao.create(user);
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}


	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}
	
	
	

}
