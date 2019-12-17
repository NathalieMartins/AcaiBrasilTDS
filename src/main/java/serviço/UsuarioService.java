package serviço;

import java.util.List;
import java.util.Optional;

import MODEL.MoUsuario;


public interface UsuarioService {
	
	List<MoUsuario> findAll();
	
	Optional<MoUsuario> findById(Long id);
	
	MoUsuario persist(MoUsuario usuario);	
	
	void delete(Long id);
	
	MoUsuario findOne(Long id);
}
