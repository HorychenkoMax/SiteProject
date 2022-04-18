package ua.itea.service;

import java.util.List;

import ua.itea.dao.FactoryDao;
import ua.itea.dao.ProductDAO;
import ua.itea.model.Product;

public class ProductService implements ProductDAO{
	FactoryDao factory;
	ProductDAO productDao;

	public ProductService() {
		factory = FactoryDao.newInstance();
		productDao = factory.getProductDao();

	}

	public List<Product> getAll() {
		return productDao.getAll();
	}
	
	public List<Product> getByCategory(String categoryName){
		return productDao.getByCategory(categoryName);
	}

	@Override
	public Product getById(int id) {
		return productDao.getById(id);
	}

}
