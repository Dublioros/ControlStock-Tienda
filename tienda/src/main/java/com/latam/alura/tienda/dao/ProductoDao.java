package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

//creando DAO
public class ProductoDao {
    //llamando al entitymanager
    private EntityManager em;

    public ProductoDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Producto producto) {
        this.em.persist(producto);
    }
    
    public Producto consultaPorId(Long id){
        return em.find(Producto.class, id);
    }

    public List<Producto> consultarTodos(){
        String jqpl = "SELECT P Producto AS P";
        return em.createQuery(jqpl, Producto.class).getResultList(); //Consultar elementos en tabla
    }

    public List<Producto> consultaPorNombre(String nombre) {
        String jpql = " SELECT P FROM Producto AS P WHERE P.nombre =: nombre";
        return em.createQuery(jpql, Producto.class).setParameter("nombre", nombre).getResultList();
    }

    public List<Producto> consultaPorNombreDeCategoria(String name) {
        String jpql = " SELECT p FROM Producto AS p WHERE p.categoria.name=:name";
        return em.createQuery(jpql, Producto.class).setParameter("name", name).getResultList();
    }

    public BigDecimal consultarPrecioPorNombreDeProducto(String nombre) {
        String jqpl = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
        return em.createQuery(jqpl, BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
    }

}
