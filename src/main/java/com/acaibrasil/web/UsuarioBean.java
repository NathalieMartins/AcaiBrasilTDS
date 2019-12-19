package com.acaibrasil.web;

import com.acaibrasil.data.ConexaoHibernate;
import com.acaibrasil.model.MoUsuario;
import com.acaibrasil.rn.UsuarioRN;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="usuarioBean") // mapeamento 
@RequestScoped  

    public class UsuarioBean {
    
         private String nome;
         private String senha;
         private String email;
         private String telefone;
         private String cpf;
//         private Long tiposuario;
         private String confirmaSenha;
         
	private UsuarioRN rn  = new UsuarioRN();
//        private MoUsuario usuario = new MoUsuario();
        
	
	public String salvar() { 
            
             FacesContext context = FacesContext.getCurrentInstance();
             MoUsuario usuario = new MoUsuario();
             usuario.setNome(nome);
             usuario.setSenha(senha);
             usuario.setEmail(email);
             usuario.setTelefone(telefone);
             usuario.setCpf(cpf);
            			
                if(senha == confirmaSenha){
                    
                        FacesMessage senhaMessage = new FacesMessage("Senha incorreta");
			context.addMessage(null, senhaMessage);
                    }
                         rn.salvar(usuario);
           
		
		if (!rn.salvar(usuario)) {
			FacesMessage facesMessage = new FacesMessage("Não foi possível fazer um cadastro");
			context.addMessage(null, facesMessage);
			return null;
		}

              return null;
	}

            public UsuarioRN getRn() {
                return rn;
            }

            public void setRn(UsuarioRN rn) {
                this.rn = rn;
            }

        //    public MoUsuario getUsuario() {
        //        return usuario;
        //    }
        //
        //    public void setUsuario(MoUsuario usuario) {
        //        this.usuario = usuario;
        //    }

            public String getConfirmaSenha() {
                return confirmaSenha;
            }

            public void setConfirmaSenha(String confirmaSenha) {
                this.confirmaSenha = confirmaSenha;
            }

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }

            public String getSenha() {
                return senha;
            }

            public void setSenha(String senha) {
                this.senha = senha;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getTelefone() {
                return telefone;
            }

            public void setTelefone(String telefone) {
                this.telefone = telefone;
            }

            public String getCpf() {
                return cpf;
            }

            public void setCpf(String cpf) {
                this.cpf = cpf;
            }

        //    public Long getTiposuario() {
        //        return tiposuario;
        //    }
        //
        //    public void setTiposuario(Long tiposuario) {
        //        this.tiposuario = tiposuario;
        //    }

            
    }
