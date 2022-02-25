package com.desafiolatam.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.web.models.Auto;

@WebServlet("/autos")
public class AutosController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Auto> autos = new ArrayList<Auto>();
		Auto auto1 = new Auto("Nissan",1.6f,"Negro",240f);
		Auto auto2 = new Auto("Toyota",2.0f,"Azul",240f);
		Auto auto3 = new Auto("Chevrolet",2.4f,"Blanco",300f);
		Auto auto4 = new Auto("BMW",3.0f,"Verde",360f);
		
		//agregar Autos a la lista
		autos.add(auto1);
		autos.add(auto2);
		autos.add(auto3);
		autos.add(auto4);
		
		//agregar al request
		request.setAttribute("titulo", "Lista de Autos");
		request.setAttribute("listaAutos", autos);
		
		//redireccionamiento
		request.getRequestDispatcher("autos.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
