package com.desafiolatam.web.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.desafiolatam.web.basedatos.BaseDatos;
import com.desafiolatam.web.models.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	// ConexionBD conexionBD = new ConexionBD();// oracle
	BaseDatos conexionBD = new BaseDatos();// mysql
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;

	@Override
	public Usuario obtenerUsuario(String email) {

		Usuario usuario = new Usuario();
		String query = "select * FROM usuarios where correo = '" + email + "'";

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				// los numero entre () son los numeros de las columnas
				int usuarioId = resultado.getInt(1);
				String usuarioNombre = resultado.getString(2);
				String usuarioApellido = resultado.getString(3);
				String usuarioCorreo = resultado.getString(4);
				String usuarioPassword = resultado.getString(5);
				int usuarioGenero = resultado.getInt(6);

				System.out.println("nombre: " + usuarioNombre);

				usuario.setId(resultado.getInt(1));
				usuario.setNombre(usuarioNombre);
				usuario.setApellido(usuarioApellido);
				usuario.setCorreo(usuarioCorreo);
				usuario.setPassword(usuarioPassword);
				usuario.setGenero(usuarioGenero);

			}

		} catch (Exception e) {
			System.out.println("Error al obtener usuario " + e);
		}

		return usuario;

	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int crearUsuario(Usuario usuario) {
		int resultado = 0;
		String query = "INSERT INTO USUARIOS(nombre, apellido, correo, password, genero) " + "values ('"
				+ usuario.getNombre() + "','" + usuario.getApellido() + "','" + usuario.getCorreo() + "','"
				+ usuario.getPassword() + "','" + usuario.getGenero() + "' )";

		System.out.println(query);// ver como queda la query

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query);// al insertar retorna 1 o 0

			if (resultado == 1) {
				System.out.println("Insercion correcta de usuario");
			} else {
				System.out.println("Error al insertar usuario");
			}

			
		} catch (Exception e) {
			System.out.println("Error al obtener usuario " + e);
		}
		return resultado;
	}

}
