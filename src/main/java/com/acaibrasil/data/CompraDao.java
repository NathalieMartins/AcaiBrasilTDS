/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.data;

import com.acaibrasil.model.MoCompra;
import com.mysql.jdbc.Connection;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Acer
 */
public class CompraDao {
    
        public void save (MoCompra compra){
           ConexaoHibernate.getInstance().getTransaction().begin();
           ConexaoHibernate.getInstance().persist(compra);
           ConexaoHibernate.getInstance().getTransaction().commit();

        }

    public List<MoCompra> list(Long id){
        String sql = "select NEW com.acaibrasil.data;" +
            "(compra.id) " +
            "from tb_compra compra";
        TypedQuery<MoCompra> query = ConexaoHibernate.getInstance().createQuery(sql, MoCompra.class);
        return query.getResultList();
    }

    public MoCompra get(Long id){
        String sql = "SELECT compra "+
            "FROM tb_compra compra " +
            "WHERE compra.id = :id";
            
        TypedQuery<MoCompra> query = ConexaoHibernate.getInstance().createQuery(sql, MoCompra.class);
        query.setParameter("id",id);
        MoCompra compra = query.getSingleResult();

        return compra;
    }

    public void delete(Long id){
        MoCompra compra = get(id);
        ConexaoHibernate.getInstance().getTransaction().begin();
        ConexaoHibernate.getInstance().persist(compra);
       ConexaoHibernate.getInstance().getTransaction().commit();

    }
    
}
