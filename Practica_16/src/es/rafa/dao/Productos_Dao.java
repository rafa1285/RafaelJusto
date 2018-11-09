package es.rafa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.rafa.conexiones.ConexionMySQL;
import es.rafa.productos.Productos;

public class Productos_Dao {

	Productos producto;
	PreparedStatement st;
	ResultSet rs;
	ConexionMySQL conexion = new ConexionMySQL();

	// Consultas para interactuar con la base de datos
	String queryGuardar = "INSERT INTO producto (nombre, cantidad, precio, comentario) values (?, ?, ?, ?)";
	String queryBuscar = "SELECT * FROM producto WHERE nombre LIKE ?";

	/**
	 * Metodo que sirve para guardar un producto en la base de datos
	 * 
	 * @param producto
	 *            objeto que contiene la informacion del producto
	 * @throws SQLException
	 */
	public void guardarProductos(Productos producto) throws SQLException {
		Connection con = null;
		con = conexion.conectarMySQL();
		st = con.prepareStatement(queryGuardar);
		st.setString(1, producto.getNombre());
		st.setInt(2, producto.getCantidad());
		st.setDouble(3, producto.getPrecio());
		st.setString(4, producto.getComentario());
		// st.setDate(5, new java.sql.Date(producto.getFecha()));
		st.executeUpdate();
		conexion.cerrarConexion();
	}

	/**
	 * Metodo que obtiene los productos de la base de datos y la guarda en una lista
	 * para poder recorrerla e imprimirla
	 * 
	 * @param nombreProducto
	 *            Variable que establece un filtro para buscar por nombre de
	 *            producto
	 * @return Retorna una lista de productos
	 * @throws SQLException
	 */
	public List<Productos> listarProductos(String nombreProducto) throws SQLException {
		List<Productos> listaProductos = new ArrayList<Productos>();
		Connection con = null;
		con = conexion.conectarMySQL();
		st = con.prepareStatement(queryBuscar);
		st.setString(1, "%" + nombreProducto + "%");
		rs = st.executeQuery();
		while (rs.next()) {
			producto = new Productos();
			// String nombre = rs.getString(1);
			// Integer cantidad = rs.getInt(2);
			// double precio = rs.getDouble(3);
			// String comentario = rs.getString(4);
			producto.setId(rs.getInt(1));
			producto.setNombre(rs.getString(2));
			producto.setCantidad(rs.getInt(3));
			producto.setPrecio(rs.getDouble(4));
			producto.setComentario(rs.getString(5));
			listaProductos.add(producto);
		}
		conexion.cerrarConexion();
		return listaProductos;

	}

}
