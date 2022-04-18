package ua.itea.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.itea.dao.mysql.MySQLProductDAO;
import ua.itea.model.Product;
import ua.itea.service.ProductService;

public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productDAOController = new ProductService();

	public CartController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/cart-view.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		int productId = Integer.valueOf(request.getParameter("id"));
		int numberOfProduct = Integer.valueOf(request.getParameter("numberOfProduct"));
		HttpSession session = request.getSession();
		Product product = productDAOController.getById(productId);
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", new HashMap<Product, Integer>());
			session.setAttribute("numberOfProduct", 0);
		}
		Map<Product, Integer> productMap = (Map<Product, Integer>) session.getAttribute("cart");
		if (productMap.containsKey(product)) {
			Integer number = productMap.get(product) + numberOfProduct;
			productMap.put(product, number);
		} else {
			productMap.put(product, numberOfProduct);
		}
		int numberProduct = (int) session.getAttribute("numberOfProduct");
		session.setAttribute("numberOfProduct", ++numberProduct);
		session.setAttribute("cart", productMap);
		System.out.println(productMap);
		writer.write("" + numberProduct);
	}

}
