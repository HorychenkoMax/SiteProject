package ua.itea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.itea.service.RegistrationCheckService;
import ua.itea.service.RegistrationUserService;

public class RegistrationUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistrationUserService registrationService = new RegistrationUserService();

	public RegistrationUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("isAuthorized") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration-view.jsp");
			rd.forward(request, response);
		} else if (session.getAttribute("isAuthorized") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/logOut-view.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RegistrationCheckService registrationCheckService = new RegistrationCheckService();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String repassword = request.getParameter("re-password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String comment = request.getParameter("comment");
		System.out.println(
				login + " " + password + " " + repassword + " " + name + " " + gender + " " + address + " " + comment);
		HttpSession session = request.getSession();
		if (session.getAttribute("isAuthorized") == null) {

			if (!registrationCheckService.IsRegistrationCorrect(login, password, repassword, name, gender, address,
					comment)) {
				if (!registrationService.isUserLoginExists(login)) {
					registrationService.insertUser(name, login, repassword, gender, address, comment);
					System.out.println("yes");
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/login-view.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("errorText", "User is exist");
					RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration-view.jsp");
					rd.forward(request, response);
				}
			} else {
				request.setAttribute("errorText", registrationCheckService.getError());
				request.setAttribute("login", login);
				request.setAttribute("password", password);
				request.setAttribute("repassword", repassword);
				request.setAttribute("name", name);
				System.out.println("no");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/registration-view.jsp");
				rd.forward(request, response);
			}
		}

	}

}
