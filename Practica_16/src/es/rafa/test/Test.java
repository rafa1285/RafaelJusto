package es.rafa.test;

import java.sql.SQLException;
import es.rafa.dao.Productos_Dao;
import es.rafa.productos.Productos;

public class Test {

	public static void main(String[] args) {

		Productos producto = new Productos();
		Productos_Dao prodDao = new Productos_Dao();

		producto.setNombre("Movil");
		producto.setCantidad(2);
		producto.setPrecio(586);
		producto.setComentario("Samsung reparado");

		try {
			prodDao.guardarProductos(producto);
			Iterable<Productos> lista = prodDao.listarProductos("");
			for (Productos elem : lista) {
				System.out.println(elem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			e.getCause();
		}

	}

}
