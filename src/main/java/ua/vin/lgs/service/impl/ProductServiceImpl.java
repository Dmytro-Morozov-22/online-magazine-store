package ua.vin.lgs.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import ua.vin.lgs.domain.Product;
import ua.vin.lgs.service.ProductService;
import ua.vin.lgs.dao.ProductDao;
import ua.vin.lgs.dao.impl.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;
	private static ProductService productServiceImpl;
	private static Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);

	public ProductServiceImpl() {
		
		try {
			productDao = new ProductDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | SQLException e) {
			LOGGER.error(e);
		}
	}

	
	public static ProductService getProductServiceImpl() {
		if(productServiceImpl == null) {
			productServiceImpl = new ProductServiceImpl();
		}
		return productServiceImpl;
	}
	
	
	@Override
	public Product create(Product product) {
		return productDao.create(product);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product product) {
		return productDao.update(product);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}
}
