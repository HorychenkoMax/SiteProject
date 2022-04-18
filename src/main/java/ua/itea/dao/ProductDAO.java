package ua.itea.dao;

import java.util.List;

import ua.itea.model.Product;


public interface ProductDAO {
	List<Product> getAll();
	List<Product> getByCategory(String categoryName);
	Product getById(int id);
}
