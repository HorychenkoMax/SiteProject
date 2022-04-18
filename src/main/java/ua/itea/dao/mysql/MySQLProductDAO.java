package ua.itea.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ua.itea.dao.ProductDAO;
import ua.itea.model.Product;

public class MySQLProductDAO implements ProductDAO {
	private MySQLFactoryDao factory;
	Logger logger = Logger.getLogger(MySQLProductDAO.class.getSimpleName());
	public static final String ALL_PRODUCTS = "SELECT * FROM `products`";
	public static final String GET_PRODUCTS_BY_CATEGORY = "SELECT products.id, products.name, products.price, products.description FROM products_to_categories JOIN `products` ON products_to_categories.product_id = products.id JOIN categories ON products_to_categories.category_id = categories.id WHERE categories.name=?;";
	public static final String GET_PRODUCTS_BY_ID = "SELECT * FROM `products` WHERE id = ?;";
	
	public MySQLProductDAO(MySQLFactoryDao factory) {
		this.factory = factory;
	}

	@Override
	public List<Product> getAll() {
		Connection conn = factory.creatConnection();
		List<Product> productList = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(ALL_PRODUCTS);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				productList.add(product);
			}

		} catch (SQLException e) {
			logger.info("SQL Exception " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
				} // ignore
				conn = null;
			}
		}

		return productList;
	}

	@Override
	public List<Product> getByCategory(String categoryName) {
		Connection conn = factory.creatConnection();
		List<Product> productList = new ArrayList<Product>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(GET_PRODUCTS_BY_CATEGORY);
			stmt.setString(1, categoryName);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				productList.add(product);
			}

		} catch (SQLException e) {
			logger.info("SQL Exception " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
				} // ignore
				conn = null;
			}
		}

		return productList;
	}

	@Override
	public Product getById(int id) {
		Connection conn = factory.creatConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product product = new Product();

		try {
			stmt = conn.prepareStatement(GET_PRODUCTS_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setDescription(rs.getString("description"));
				
			}

		} catch (SQLException e) {
			logger.info("SQL Exception " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				} // ignore
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				} // ignore
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlEx) {
				} // ignore
				conn = null;
			}
		}

		return product;
	}

}
