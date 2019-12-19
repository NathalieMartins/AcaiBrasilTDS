/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.rn;

import com.acaibrasil.data.UsuarioDao;
import com.acaibrasil.model.MoUsuario;
import java.util.List;

/**
 *
 * @author Acer
 */
public class UsuarioRN {
    
    private UsuarioDao usuariodao;

	public UsuarioRN() {
		this.usuariodao = new UsuarioDao();
	}

	public MoUsuario login(MoUsuario usuario) {
		return this.usuariodao.login(usuario);
	}


	public Boolean salvar(MoUsuario usuario) {
            MoUsuario usuarioBD  = usuariodao.get(usuario.getEmail());
            Boolean resultado;
		if (usuarioBD == null) {
			usuario.setTipousuario(new Long("0")); 
			this.usuariodao.save(usuario);
                        resultado = true;
		} else {
			resultado = false;
		}
                
           return resultado;
	}
        

	public void excluir(MoUsuario usuario) {
            
             MoUsuario usuarioDEL  = usuariodao.get(usuario.getNome());
             
              Boolean resultado;
		if (usuarioDEL != null) {
			usuario.getNome(); 
			this.usuariodao.delete(usuario);
                        resultado = true;
		} else {
			resultado = false;
		}
            
           
            
            this.usuariodao.delete(usuario);
	}

	public List<MoUsuario> listar() {
		return this.usuariodao.list();
	}
     
}  
