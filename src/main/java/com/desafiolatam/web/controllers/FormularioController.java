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

import com.desafiolatam.web.DAO.UsuarioDAOImpl;
import com.desafiolatam.web.models.Usuario;

@WebServlet("/formulario")
public class FormularioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession sesion = request.getSession(true);
		
		//capturando los parametros pasados por url(GET)
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String genero = request.getParameter("genero");
		
		//validar informacion
		if(nombre.equals("") || apellido.equals("") || correo.equals("") || password.equals("")|| genero == null) {
			pw.println("<p>Error en el envio de parametros</p>");//registro.jsp
		}else {
			Usuario usuario = new Usuario(nombre,apellido,correo,password,Integer.parseInt(genero));
			
			//TODO almacenar en base datos
			UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
			
			Usuario usuarioDB = usuarioDAOImpl.obtenerUsuario(correo);
			if (usuarioDB==null) {//NO EXISTE EL USUARIO CON ESE EMAIL
			
				int resultadoInsert = usuarioDAOImpl.crearUsuario(usuario);
				
				if (resultadoInsert == 1) {
					System.out.println("Insercion correcta de usuario");
					
					RequestDispatcher vista = request.getRequestDispatcher("login.jsp");
					vista.forward(request, response);//redireccionamiento
				} else {
					System.out.println("Error al insertar usuario");
					request.setAttribute("msgError", "Error al insertar usuario");
					
					RequestDispatcher vista = request.getRequestDispatcher("registro.jsp");
					vista.forward(request, response);//redireccionamiento
				}
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
