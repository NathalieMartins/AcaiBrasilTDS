/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.data;

import com.acaibrasil.model.MoAcai;
import com.mysql.jdbc.Connection;
import java.util.List;
import javax.persistence.TypedQuery;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Acer
 */
public class AcaiDao {
    
    public void save (MoAcai acai){
       ConexaoHibernate.getInstance().getTransaction().begin();
       ConexaoHibernate.getInstance().persist(acai);
       ConexaoHibernate.getInstance().getTransaction().commit();
    }
////    
////    public List<MoAcai> list(){
////        
////        String sql = "select NEW com.acaibrasil.data;" +
////            "(acai.id,  acai.valor, acai.tamanho ) " +
////            "from Usuario u";
//////        TypedQuery<MoAcai> query =  ConexaoHibernate.getInstance().createQuery(sql, MoAcai.class);
////        return query.getResultList();
////    }
//
//    public MoAcai get(Long id){
//        
//        String sql = "SELECT acai "+
//            "FROM tb_acai acai " +
//            "WHERE acai.tamanho = :tamanho";
//            
//        TypedQuery<MoAcai> query =  ConexaoHibernate.getInstance().createQuery(sql, MoAcai.class);
//        query.setParameter("id",id);
//        MoAcai acai = query.getSingleResult();
//
//        return acai;
//    }
//
//    public void delete(Long id){
//        
//        MoAcai acai = get(id);
//        ConexaoHibernate.getInstance().getTransaction().begin();
//        ConexaoHibernate.getInstance().persist(acai);
//       ConexaoHibernate.getInstance().getTransaction().commit();
//    }

    
}
