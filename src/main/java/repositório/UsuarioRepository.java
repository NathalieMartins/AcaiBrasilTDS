package repositório;

import MODEL.MoCopo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import MODEL.MoUsuario;

@Repository
public interface UsuarioRepository extends JpaRepository<MoUsuario, Long>{

	MoUsuario findPessoaById(Long id);

    public MoCopo findCopoById(Long id);
	
}
