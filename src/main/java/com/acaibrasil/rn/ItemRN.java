/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acaibrasil.rn;

import com.acaibrasil.data.ItemDao;
import com.acaibrasil.model.MoItem;

import java.util.List;

/**
 *
 * @author Acer
 */
public class ItemRN {
    private ItemDao itemdao;

	public ItemRN() {
		this.itemdao = new ItemDao();
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
        

	public void excluir(MoItem item) {
            
             MoItem ItemDEL  = itemdao.get(item.getDescricao());
             
              Boolean resultado;
		if (ItemDEL != null) {
			item.getDescricao(); 
			this.itemdao.delete(item);
                        resultado = true;
		} else {
			resultado = false;
		}
            
           
            
            this.itemdao.delete(item);
	}

//	public List<MoItem> listar() {
//		return this.itemdao.list();
//	}
     
}
