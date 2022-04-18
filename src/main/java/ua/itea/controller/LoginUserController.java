package ua.itea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.itea.model.User;
import ua.itea.service.LoginUserService;

public class LoginUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginUserService loginService = new LoginUserService();

	public LoginUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("isAuthorized") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login-view.jsp");
			rd.forward(request, response);
		} else if (session.getAttribute("isAuthorized") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/logOut-view.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("isAuthorized") == null) {
			String login = request.getParameter("login");
			String password = request.getParameter("password");
			User user = loginService.getUserByLoginAndPassword(login, password);
			if (user != null) {
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/logOut-view.jsp");
				session.setAttribute("isAuthorized", true);
				session.setAttribute("User", user.getName());
				rd.forward(request, response);
				System.out.println("login");
			} else {
				System.out.println("not login");
				doGet(request, response);
			}
		} else if (session.getAttribute("isAuthorized") != null) {
			session.invalidate();
			session = request.getSession();
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login-view.jsp");
			System.out.println("logout");
			rd.forward(request, response);
		}

	}

}
