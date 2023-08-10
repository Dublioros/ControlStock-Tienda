package com.latam.alura.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {

    //crear entitymanager factory atravez de la unidad de persistencia del xml con el nombre
    private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("tienda");

    //Meotodo statico que nos permite crear el entity manager
    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }

}
