package com.acaibrasil.web;

import com.acaibrasil.model.MoUsuario;
import com.acaibrasil.rn.UsuarioRN;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="usuarioBean")
@RequestScoped  
public class UsuarioBean {

    private String confirmaSenha;
    private MoUsuario usuario = new MoUsuario();
        
    private UsuarioRN rn  = new UsuarioRN();
        
    public String salvar() { 
        FacesContext context = FacesContext.getCurrentInstance();
        if(!usuario.getSenha().equals(confirmaSenha)){
            FacesMessage senhaMessage = new FacesMessage("Senha incorreta");
            context.addMessage(null, senhaMessage);
        }
                
        if (!rn.salvar(usuario)) {
            FacesMessage facesMessage = new FacesMessage("Não foi possível fazer um cadastro");
            context.addMessage(null, facesMessage);
            return null;
        }

        return null;
    }


    public String getConfirmaSenha() {
        return this.confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public MoUsuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(MoUsuario usuario) {
        this.usuario = usuario;
    }

}
