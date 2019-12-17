package MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class MoUsuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;
	
	@Column(name = "nome")
	private String nome;
	
        @Column(name = "senha")
	private int senha;
        
	@Column(name = "email")
	private String email;

	@Column(name = "telefone")
	private String telefone;
        
	@Column(name = "cpf")
	private int cpf;
       
        @Column(name = "tipousuario")
	private int tipousuario;
            
	public MoUsuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
        
        public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
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
        
        public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
        
        public int getTipoUsuario() {
		return tipousuario;
	}

	public void setTipoUusiario(int tipousuario) {
		this.tipousuario = tipousuario;
	}
        

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		MoUsuario other = (MoUsuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
