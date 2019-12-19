/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.rn;

import com.acaibrasil.data.CompraDao;
import com.acaibrasil.model.MoCompra;
import java.util.List;

/**
 *
 * @author Acer
 */
public class CompraRN {
    
    
     private CompraDao compradao;

	public CompraRN() {
		this.compradao = new CompraDao();
	}

//	public MoItem login(MoUsuario usuario) {
//		return this.usuariodao.login(usuario);
//	}
//
//
//	public Boolean salvar(MoUsuario usuario) {
//            MoUsuario usuarioBD  = usuariodao.get(usuario.getEmail());
//            Boolean resultado;
//		if (usuarioBD == null) {
//			usuario.setTipousuario(new Long("0")); 
//			this.usuariodao.save(usuario);
//                        resultado = true;
//		} else {
//			resultado = false;
//		}
//                
//           return resultado;
//	}
        

	public void excluir(MoCompra compra) {
            
             MoCompra CompraDEL  = compradao.get(compra.getId());
             
              Boolean resultado;
		if (CompraDEL != null) {
			compra.getId(); 
			this.compradao.delete(compra);
                        resultado = true;
		} else {
			resultado = false;
		}
            
           
            
            this.compradao.delete(compra);
	}

//	public List<MoCompra> listar() {
//		return this.compradao.list();
//	}
  
}

    

