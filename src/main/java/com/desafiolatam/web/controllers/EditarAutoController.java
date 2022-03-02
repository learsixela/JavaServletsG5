package com.desafiolatam.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.web.DAO.AutoDAOImpl;

@WebServlet("/administrarAutos")
public class EditarAutoController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "showAuto":
			editar(request, response);// llamado a la funcion
			break;
		case "eliminar":
			eliminar(request, response);// llamado a la funcion
			break;

		default:
			break;
		}

		// redireccionamiento
		request.getRequestDispatcher("autos.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");//capturamos
		Integer autoId = Integer.parseInt(id);//convertimos
		
		AutoDAOImpl autoDAOImpl = new AutoDAOImpl();//instancia para acceder metodo
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");//capturamos
		Integer autoId = Integer.parseInt(id);//convertimos

		AutoDAOImpl autoDAOImpl = new AutoDAOImpl();
		autoDAOImpl.eliminarAuto(autoId);
	}

}
