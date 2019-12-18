/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.data;

import com.acaibrasil.model.MoUsuario;
import com.mysql.jdbc.Connection;
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
        String sql = "select NEW ccom.acaibrasil.data" +
            "(usuario.id,  usuario.nome, usuario.senha, usuario.email, " +
            "usuario.telefone, usuario.cpf, " +
            "usuario.TipoUsuario) " +
            "from tb_usuario usuario";
        TypedQuery<MoUsuario> query = ConexaoHibernate.getInstance().createQuery(sql, MoUsuario.class);
        return query.getResultList();
    }

    public MoUsuario get(String email){
        String sql = "SELECT u "+
            "FROM MoUsuario u " +
            "WHERE usuario.email = :email";
            
        TypedQuery<MoUsuario> query = ConexaoHibernate.getInstance().createQuery(sql, MoUsuario.class);
        query.setParameter("email",email);
        MoUsuario usuario = query.getSingleResult();
        return usuario;
    }

    public void delete(MoUsuario usuario){
         ConexaoHibernate.getInstance().getTransaction().begin();
        ConexaoHibernate.getInstance().persist(usuario);
          ConexaoHibernate.getInstance().getTransaction().commit();
    }

  
    
    
    public MoUsuario login(MoUsuario usuario){
        String sql = "select usuario "+
                        "from MoUsuario usuario " +
                        "where usuario.nome = :nome and " +
                        "usuario.senha = :senha";
        TypedQuery<MoUsuario> query = ConexaoHibernate.getInstance().createQuery(sql, MoUsuario.class);
        query.setParameter("nome",usuario.getNome());
        query.setParameter("senha",usuario.getSenha());
        MoUsuario u = query.getSingleResult();

        return u;
    
    }
    
}
