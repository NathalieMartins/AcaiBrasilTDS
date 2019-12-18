package com.acaibrasil.web;

import com.acaibrasil.data.AcaiDao;
import com.acaibrasil.data.CompraDao;
import com.acaibrasil.data.ConexaoHibernate;
import com.acaibrasil.data.ItemDao;
import com.acaibrasil.data.UsuarioDao;
import com.acaibrasil.model.MoAcai;
import com.acaibrasil.model.MoCompra;
import com.acaibrasil.model.MoItem;
import com.acaibrasil.model.MoUsuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="usuarioBean") // mapeamento 
@RequestScoped  
public class UsuarioBean {
	private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;
	
	public String novo() { //(_1_)
		return "usuario";
	}
	public String salvar() { //(_2_)
		FacesContext context = FacesContext.getCurrentInstance(); 
		if (!this.senha.equalsIgnoreCase(this.confirmaSenha)) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
				"Senha confirmada incorretamente",""));
			return "usuario"; //(_3_)
		}
		// FUTURO - salva o usuï¿½rio
		return "mostrausuario"; //(_4_)
	}

       public String Conexao(){
           
           MoUsuario usuario = new MoUsuario();
           usuario.setCpf("12345");
           usuario.setEmail("raissap@alunos");
           usuario.setNome("João");
           usuario.setSenha(123);
           usuario.setTelefone("88181919");
           usuario.setTipousuario(new Long("1"));
           
           
           MoCompra compra = new MoCompra();
           compra.setUsuario(usuario);
        
         
             MoAcai acai = new MoAcai();
             //acai.setCompra(compra);
            acai.setTamanho("grande");
            acai.setValor(new Double("10.89"));
           
           
           MoItem item = new MoItem();
           item.setAcai(acai);
           item.setDescricao("banana e morango");
           item.setValor(new Double("5.00"));
           
           
//           System.out.println(usuario);
           
           
//           AcaiDao acaidao = new AcaiDao();
             UsuarioDao usuariodao = new UsuarioDao();
            usuariodao.save(usuario);
            usuariodao.login(usuario);
             
          CompraDao compradao = new CompraDao();
          compradao.save(compra);
           
           AcaiDao  acaidao = new AcaiDao();
           acaidao.save(acai);
           
             ItemDao itemdao = new ItemDao();
             itemdao.save(item);
              MoUsuario u = usuariodao.login(usuario);
             if( u == null){
                 
                        System.out.println("deu errado");
                        return null;
             }
             
             
             
             System.out.println(u);
             
           
           return "index.xhtml";
       }
       
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
}
