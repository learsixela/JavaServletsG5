package com.desafiolatam.web.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.desafiolatam.web.basedatos.BaseDatos;
import com.desafiolatam.web.models.Auto;

public class AutoDAOImpl implements AutoDAO {
	BaseDatos conexionBD = new BaseDatos();// mysql
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;
	
	@Override
	public ArrayList<Auto> listarAutos() {
		
		ArrayList<Auto> listaAutos = new ArrayList<Auto>();
		String query = "SELECT * FROM AUTOS";
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				Integer id = resultado.getInt(1);//resultado.getInt("id");
				String marca = resultado.getString(2);
				Float motor = resultado.getFloat(3);
				String color = resultado.getString(4);
				Float velocidad = resultado.getFloat(5);
				
				Auto auto = new Auto(marca, motor,color,velocidad);
				auto.setId(id);
				
				listaAutos.add(auto);//agregando auto a la lista

			}
			
		} catch (Exception e) {
			System.out.println("Error al obtener usuario " + e);
		}
		
		return listaAutos;
	}

	@Override
	public Auto obtenerAuto(Integer id) {
		//Auto auto =  new Auto();
		Auto auto = null;
		String query = "SELECT * FROM AUTOS WHERE ID = '"+id+"'";
		
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				Integer autoId = resultado.getInt(1);//resultado.getInt("id");
				String marca = resultado.getString(2);
				Float motor = resultado.getFloat(3);
				String color = resultado.getString(4);
				Float velocidad = resultado.getFloat(5);
				
				/*auto.setId(autoId);
				auto.setMarca(marca);
				auto.setMotor(motor);
				auto.setColor(color);
				auto.setVelocidad(velocidad);*/
				
				auto =  new Auto(marca, motor,color,velocidad);
				auto.setId(autoId);
			}
			
		} catch (Exception e) {
			System.out.println("Error al obtener usuario " + e);
		}
		
		return auto;
	}

}
