package com.acaibrasil.data;


/**
 *
 * @author natha
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/*
    Esta classe representa a Conexão Hibernate.
*/
public class ConexaoHibernate {
    private static EntityManagerFactory factory;
    private volatile static EntityManager manager;
    
    private ConexaoHibernate(){
    }
    /*
        @brief Obtém a instância ativa do hibernate.
        @return O manager com a instância ativa do hibernate.
    */
    public static EntityManager getInstance(){
        if (manager == null){
            synchronized(ConexaoHibernate.class){
                if(manager == null){
                    factory = Persistence.createEntityManagerFactory("acai");
                    manager = factory.createEntityManager();
                }
            }
        }
        return manager;
    }
}
