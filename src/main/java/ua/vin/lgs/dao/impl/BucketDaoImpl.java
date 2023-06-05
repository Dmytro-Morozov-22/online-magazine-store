package ua.vin.lgs.dao.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.vin.lgs.domain.Bucket;
import ua.vin.lgs.dao.BucketDao;
import ua.vin.lgs.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao {

	private static String READ_ALL = "select * from bucket";
	private static String CREATE = "insert into bucket(`user_id`, `product_id`, `purchase_date`) values (?,?,?)";
	private static String READ_BY_ID = "select * from bucket where id = ?";
	private static String DELETE_BY_ID = "delete from bucket where id = ?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	private static Logger LOGGER = Logger.getLogger(BucketDaoImpl.class);
	
	
	public BucketDaoImpl()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Bucket create(Bucket bucket) {
		try {
			preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, bucket.getUserId());
			preparedStatement.setInt(2, bucket.getProductId());
			preparedStatement.setDate(3, new Date(bucket.getPurchaseDate().getTime()));
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			bucket.setId(rs.getInt(1));
			
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return bucket;
	}

	@Override
	public Bucket read(Integer id) {

		Bucket bucket = null;

		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer bucketId = result.getInt("id");
			Integer userId = result.getInt("user_id");
			Integer productId = result.getInt("product_id");
			Date purchaseDate = result.getDate("purchase_date");

			bucket = new Bucket(bucketId, userId, productId, purchaseDate);

		} catch (SQLException e) {
			LOGGER.error(e);
		}

		return bucket;
	}

	@Override
	public Bucket update(Bucket t) {
		throw new IllegalStateException("Метод не реалізований - The method is not realise");
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}

	}

	@Override
	public List<Bucket> readAll() {
		List<Bucket> bucketRecords = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer bucketId = result.getInt("id");
				Integer userId = result.getInt("user_id");
				Integer productId = result.getInt("product_id");
				Date purchaseDate = result.getDate("purchase_date");
				bucketRecords.add(new Bucket(bucketId, userId, productId, purchaseDate));
			}

		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return bucketRecords;
	}

}
