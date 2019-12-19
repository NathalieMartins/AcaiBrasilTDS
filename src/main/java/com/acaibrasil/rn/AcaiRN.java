/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.rn;

import com.acaibrasil.data.AcaiDao;
import com.acaibrasil.model.MoAcai;
import com.acaibrasil.model.MoItem;
import java.util.List;

/**
 *
 * @author Acer
 */
public class AcaiRN {
    
    
      private AcaiDao acaidao;

	public AcaiRN() {
		this.acaidao = new AcaiDao();
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
        

	public void excluir(MoAcai acai) {
            
             MoAcai AcaiDEL  = acaidao.get(acai.getId());
             
              Boolean resultado;
		if (AcaiDEL != null) {
			acai.getId(); 
			this.acaidao.delete(acai);
                        resultado = true;
		} else {
			resultado = false;
		}
            
           
            
            this.acaidao.delete(acai);
	}

//	public List<MoAcai> listar() {
//		return this.acaidao.list();
//	}
  
}
