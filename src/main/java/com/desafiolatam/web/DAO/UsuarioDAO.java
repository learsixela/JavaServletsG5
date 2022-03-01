package com.desafiolatam.web.DAO;

import java.sql.SQLException;

import com.desafiolatam.web.models.Usuario;

public interface UsuarioDAO {

	//definir 4 metodos
	//obtener; actualizar;eliminar;crear
	
	public Usuario obtenerUsuario(String email)throws ClassNotFoundException, SQLException;
	public void actualizarUsuario(Usuario usuario);
	public void eliminarUsuario(Integer id);
	public int crearUsuario(Usuario usuario);
	
	
}
