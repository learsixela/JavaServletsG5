package com.desafiolatam.web.DAO;

import java.util.ArrayList;

import com.desafiolatam.web.models.Auto;

public interface AutoDAO {

	public ArrayList<Auto> listarAutos();
	public Auto obtenerAuto(Integer id);
	public void eliminarAuto(Integer id);
}
