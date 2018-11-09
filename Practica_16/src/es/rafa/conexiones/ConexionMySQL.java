package es.rafa.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

	Connection conn = null;

	// Librería de MySQL
	public String driver = "com.mysql.jdbc.Driver";
	// Nombre de la base de datos
	public String database = "inventario";
	// Host
	public String hostname = "127.0.0.1";
	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	public String url = "jdbc:mysql://" + hostname + "/" + database;
	// Nombre de usuario
	public String username = "root";
	// Clave de usuario
	public String password = "root";

	/**
	 * Metodo que realiza la conexion a la base de datos
	 * 
	 * @return Este metodo retorna una conexin
	 */
	public Connection conectarMySQL() {
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * Metodo que cierra una conexion a la base de datos
	 * 
	 * @throws SQLException
	 */
	public void cerrarConexion() throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

}
