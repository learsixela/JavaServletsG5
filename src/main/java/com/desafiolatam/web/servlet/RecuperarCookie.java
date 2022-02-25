package com.desafiolatam.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/recuperarCookie")
public class RecuperarCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		PrintWriter print = response.getWriter();
		print.println("<html><body>");
		print.println("<h2><i>Cookie recuperada correctamente:</i></h2><br>");
		for(int i = 0; i < cookies.length; i++) {
			print.println("Id de la cookie: <strong>" + cookies[i].getValue() + "</strong>");
			print.println("<br>");
			print.println("Valor de la cookie: <strong>" + cookies[i].getName() + "</strong>");
			print.println("<br>");
		}
		print.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
