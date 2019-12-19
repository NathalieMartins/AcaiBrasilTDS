/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.data;

import com.acaibrasil.model.MoItem;
import com.mysql.jdbc.Connection;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Acer
 */
public class ItemDao {
    
    public void save (MoItem item){
        ConexaoHibernate.getInstance().getTransaction().begin();
        ConexaoHibernate.getInstance().persist(item);
       ConexaoHibernate.getInstance().getTransaction().commit();
    }

    public List<MoItem> list(){
        String sql = "select NEW com.acaibrasil.data" +
            "(  item.descricao, item.valore) " +
            "from tb_item item";
        
        TypedQuery<MoItem> query = ConexaoHibernate.getInstance().createQuery(sql, MoItem.class);
        return query.getResultList();
    }

    public MoItem get(String descricao){
        String sql = "SELECT item "+
            "FROM tb_item item " +
            "WHERE item.descricao = :descricao";
            
        TypedQuery<MoItem> query =  ConexaoHibernate.getInstance().createQuery(sql, MoItem.class);
        query.setParameter("descricao",descricao);
        MoItem item = query.getSingleResult();

        return item;
    }

    public void delete(MoItem item){
       ConexaoHibernate.getInstance().getTransaction().begin();
        ConexaoHibernate.getInstance().persist(item);
       ConexaoHibernate.getInstance().getTransaction().commit();
    }

   
  

    
}
