package services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MODEL.MoUsuario;
import repositório.UsuarioRepository;
import serviço.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository UsuarioRepository;
	
	@Override
	public List<MoUsuario> findAll() {
		
		return UsuarioRepository.findAll();
	}

	@Override
	public Optional<MoUsuario> findById(Long id) {
		
		return UsuarioRepository.findById(id);
	}

	@Override
	public MoUsuario persist(MoUsuario usuario) {
		
		return UsuarioRepository.save(usuario);
	}

	@Override
	public void delete(Long id) {
		UsuarioRepository.deleteById(id);		
	}

	@Override
	public MoUsuario findOne(Long id) {
		
		return UsuarioRepository.findPessoaById(id);
	}
}
