package com.desafiolatam.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inicio")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Logger milog = Logger.getLogger(Saludo.class.getName());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			PrintWriter pw = resp.getWriter();
			pw.println("<h1>Hola mundo</h1>");
			pw.println("<h2>Hola mundo</h2>");
			pw.println("<p>Hola mundo</p>");

			
		} catch (IOException e) {
			// milog.severe(e.getMessage());
			
			//stop;clean;publish,start
		}
	}

}
