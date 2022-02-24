package com.desafiolatam.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.web.models.Usuario;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession sesion = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//validamos
		if(email.isEmpty() || password.isEmpty()) {
			pw.println("<p>Error en el envio de parametros</p>");
		}else {
			//obtenemos de sesion
			Usuario usuario = (Usuario) sesion.getAttribute("usuario");//obteniendo el usuario guardado en el formularioController
			String correo = (String) sesion.getAttribute("email");
			
			//comparamos
			if(email.equals(correo) && password.equals(usuario.getPassword())) {
				RequestDispatcher vista = request.getRequestDispatcher("home.jsp");
				vista.forward(request, response);
			}else {
				pw.println("<p>parametros distintos</p>");
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}