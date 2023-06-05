package ua.vin.lgs.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.vin.lgs.dao.UserDao;
import ua.vin.lgs.domain.User;
import ua.vin.lgs.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao {

	private static String READ_ALL = "select * from user";
	private static String CREATE = "insert into user(`email`, `first_name`, `last_name`, `password`, `role`) values (?,?,?,?,?)";
	private static String READ_BY_ID = "select * from user where id = ?";
	private static String READ_BY_EMAIL = "select * from user where email = ?";
	private static String UPDATE_BY_ID = "update user set email = ?, first_name = ?, last_name = ?, password = ?, role = ? where id = ?";
	private static String DELETE_BY_ID = "delete from user where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public UserDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public User create(User user) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			user.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User read(Integer id) {
		User user = null;

		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer userId = result.getInt("id");
			String email = result.getString("email");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String password = result.getString("password");
			String role = result.getString("role");

			user = new User(userId, email, first_name, last_name, password, role);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User update(User user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> readAll() {
		List<User> userRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer userId = result.getInt("id");
				String email = result.getString("email");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String password = result.getString("password");
				String role = result.getString("role");
				userRecords.add(new User(userId, email, first_name, last_name, password, role));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRecords;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;

		try {
			preparedStatement = connection.prepareStatement(READ_BY_EMAIL);
			preparedStatement.setString(1, email);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer userId = result.getInt("id");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String password = result.getString("password");
			String role = result.getString("role");

			user = new User(userId, first_name, last_name, email, password, role);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}
