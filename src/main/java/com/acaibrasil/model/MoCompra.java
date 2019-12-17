/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Acer
 */

 @Entity
@Table(name = "tb_compra")
 
public class MoCompra {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcompra;
    
    @ManyToOne
    private MoUsuario usuario;

   
    public MoCompra() {

    }

    public Long getId() {
            return idcompra;
    }

    public void setId(Long idcompra) {
            this.idcompra = idcompra;
    }

    public MoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(MoUsuario usuario) {
        this.usuario = usuario;
    }
    
    

    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((idcompra == null) ? 0 : idcompra.hashCode());
            return result;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            MoCompra other = (MoCompra) obj;
            if (idcompra == null) {
                    if (other.idcompra != null)
                            return false;
            } else if (!idcompra.equals(other.idcompra))
                    return false;
            return true;
    }

	
}


