package ua.vin.lgs.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.vin.lgs.dao.BucketDao;
import ua.vin.lgs.dao.impl.BucketDaoImpl;
import ua.vin.lgs.domain.Bucket;
import ua.vin.lgs.service.BucketService;

public class BucketServiceImpl implements BucketService {

	private BucketDao bucketDao;
	private static BucketService bucketServiceImpl;
	private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
	
	public BucketServiceImpl() {
		
		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | SQLException e) {
			LOGGER.error(e);
		}	
	}

	public static BucketService getBucketServiceImpl() {
		if(bucketServiceImpl == null) {
			bucketServiceImpl = new BucketServiceImpl();
		}
		return bucketServiceImpl;
	}
	
	@Override
	public Bucket create(Bucket bucket) {
		return bucketDao.create(bucket);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket bucket) {
		return bucketDao.update(bucket);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}
	
}
