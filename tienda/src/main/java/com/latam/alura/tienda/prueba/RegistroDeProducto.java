package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;



public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1l);
		System.out.println(producto.getNombre());

		//BigDecimal precio = productoDao.consultarPrecioPorNombreDeProducto("Xiaomi RedMi");
		List<Producto> productos = productoDao.consultaPorNombreDeCategoria("CELULARES"); //Consulta por Categoria
		//List<Producto> productos = productoDao.consultaPorNombre("Xiaomi RedMi"); //Cosnulta por nombre
		//List<Producto> productos = productoDao.consultarTodos(); // Consulta de todos los elementos
		productos.forEach(prod->System.out.println(prod.getDescripcion())); //consulta productos
		System.out.println(productos);
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");

		Producto celular = new Producto("Xiaomi RedMi", "Note 10", new BigDecimal("800"), celulares);

		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		em.getTransaction().begin();

		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);

		em.getTransaction().commit();
		em.close();
	}

}