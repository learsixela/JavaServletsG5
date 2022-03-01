package com.desafiolatam.web.basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	
	private String servidor ="localhost";
	private String puerto = "1521";
	private String servicio= "orclcdb";//xe
	private String usuario = "alexis";
	private String password = "123456";
	
	private static Connection conexion = null;
	
	public Connection datos() throws SQLException{
		//registro del driver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error al registrar el driver");
		}
		
		
		//ruta de conexion
		String url = "jdbc:oracle:thin:@//"+this.servidor+":"+this.puerto+":"+this.servicio;
		String dbURL = "jdbc:oracle:thin:@localhost:1521:orclcdb";
		
		
        String strUserID = "alexis";
        String strPassword = "123456";
        
		
		//establecer la conexion
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection  conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB","system","oracle");
			//conexion = DriverManager.getConnection(url,this.usuario,this.password);
			//conexion=DriverManager.getConnection(dbURL,strUserID,strPassword);
			//conexion=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orclcdb","system","oracle");
			
			
			//conexion =DriverManager.getConnection(dbURL,"system","oracle");
		} catch (SQLException e) {
			System.out.println("Error al conectar a base datos Oracle: "+ e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conexion;
		// conexion a la base de datos y ejecucion de la sentencia
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		///Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCLCDB", "DEMO","1234");

		/*try (PreparedStatement stmt = conexion.prepareStatement(query)) {

			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {
				System.out.println("");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
		
	}

}
