/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.data;

import com.acaibrasil.model.MoUsuario;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author Acer
 */
public class UsuarioDao {
    
    
    public void save (MoUsuario usuario){
        ConexaoHibernate.getInstance().getTransaction().begin();
        ConexaoHibernate.getInstance().persist(usuario);
        ConexaoHibernate.getInstance().getTransaction().commit();
    }

    public List<MoUsuario> list(){
        String sql = "select u " +
            "from MoUsuario u";
        TypedQuery<MoUsuario> query = ConexaoHibernate.getInstance().createQuery(sql, MoUsuario.class);
        return query.getResultList();
    }

    public MoUsuario get(String email){
        String sql = "SELECT u "+
            "FROM MoUsuario u " +
            "WHERE u.email = :email";
            
        TypedQuery<MoUsuario> query = ConexaoHibernate.getInstance().createQuery(sql, MoUsuario.class);
        query.setParameter("email",email);
        MoUsuario usuario = null;
        try {
            usuario = query.getSingleResult();
        } catch (Exception e) {
            System.out.println("O usuario não existe");
        }
        
        return usuario;
    }

    public void delete(MoUsuario usuario){
         ConexaoHibernate.getInstance().getTransaction().begin();
        ConexaoHibernate.getInstance().persist(usuario);
          ConexaoHibernate.getInstance().getTransaction().commit();
    }
    
    public MoUsuario login(MoUsuario usuario){
        String sql = "select u "+
            "from MoUsuario u " +
            "where u.nome = :nome and " +
            "u.senha = :senha";
        TypedQuery<MoUsuario> query = ConexaoHibernate.getInstance().createQuery(sql, MoUsuario.class);
        query.setParameter("nome",usuario.getNome());
        query.setParameter("senha",usuario.getSenha());
        MoUsuario u = query.getSingleResult();

        return u;
    
    }
    
}
