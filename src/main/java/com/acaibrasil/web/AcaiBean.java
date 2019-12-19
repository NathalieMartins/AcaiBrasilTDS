package com.acaibrasil.web;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */

   
//    @ManagedBean(name="AcaiBean") // mapeamento 
//@RequestScoped  
//
//
//public class CopoBean {
//        
//        private int id;
//	private String descricao;
//	private float valor;
//	private int tamanho;
//
//	
//	public String novo() { //(_1_)
//		return "copo";
//	}
//	public String salvar() { //(_2_)
//		FacesContext context = FacesContext.getCurrentInstance(); 
//		if (!this.id.equalsIgnoreCase(this.confirmaId)) {
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//				"Senha confirmada incorretamente",""));
//			return "copo"; //(_3_)
//		}
//		// FUTURO - salva o copo
//		return "mostracopo"; //(_4_)
//	}
//
//
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricso(String descricao) {
//		this.descricao = descricao;
//	}
//
//	public float getValor() {
//		return valor;
//	}
//
//	public void setValor(float valor) {
//		this.valor = valor;
//	
//         }
//        
//        public int getTamanho() {
//		return tamanho;
//	}
//
//	public void setTamanho(int tamanho) {
//		this.tamanho = tamanho;
//	}
//
//
//    }