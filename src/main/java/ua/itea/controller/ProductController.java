package ua.itea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.itea.service.ProductService;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productDaoController = new ProductService();

	public ProductController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryName = request.getParameter("category");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/product-view.jsp");
		if (categoryName != null) {
			request.setAttribute("productList", productDaoController.getByCategory(categoryName));
		} else {
			request.setAttribute("productList", productDaoController.getAll());
		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
