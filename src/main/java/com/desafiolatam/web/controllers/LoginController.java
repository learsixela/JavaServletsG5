package com.desafiolatam.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.web.DAO.UsuarioDAOImpl;
import com.desafiolatam.web.models.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession sesion = request.getSession();
		RequestDispatcher vista = null;
		
		UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// validamos
		if (email.isEmpty() || password.isEmpty()) {
			request.setAttribute("msgError", "Error en los parametros");
			vista = request.getRequestDispatcher("login.jsp");
		} else {
			// obtenemos de sesion
			Usuario usuario = (Usuario) sesion.getAttribute("usuario");// obteniendo el usuario guardado en el
																		// formularioController
			String correo = (String) sesion.getAttribute("email");
			
			Usuario usuarioDB = usuarioDAOImpl.obtenerUsuario(email);

			//validacion si usuarioDB no es null
			
			
			// comparamos
			if (email.equals(correo) && password.equals(usuario.getPassword())) {
				
				// COOKIES
				Cookie cookie = new Cookie(usuario.getNombre(), usuario.getCorreo());
				cookie.setMaxAge(9000);
				cookie.setComment("Cookie guardada con propositos educativos");
				response.addCookie(cookie);

				// ver el contenido de la cookie
				/*
				 * pw.println("<html><body>");
				 * pw.println("<h2><i>Cookie guardada correctamente:</i></h2><br>");
				 * pw.println("Valor de la cookie: <strong>"+ cookie.getValue()+ "</strong>");
				 * pw.println("<br>"); pw.println("Tiempo de la duración de la cookie: <strong>"
				 * + cookie.getMaxAge()+"</strong>"); pw.println("<br>");
				 * pw.println("Comentario: <strong>" + cookie.getComment() + "</strong>");
				 * pw.println("</body></html>");
				 */

				request.setAttribute("usuario", usuario);// para traspaso a home.jsp
				vista = request.getRequestDispatcher("home.jsp");

			} else {
				request.setAttribute("msgError", "parametros distintos");
				vista = request.getRequestDispatcher("login.jsp");
			}
		}
		vista.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
