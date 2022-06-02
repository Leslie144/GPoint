package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Usuario;
import pe.edu.upc.demo.repositories.IUsuarioRepository;
import pe.edu.upc.demo.serviceinterface.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository uRepository;
	
	@Override
	public void insert(Usuario usuario) {
		uRepository.save(usuario);
		
	}

	@Override
	public List<Usuario> list() {
		
		return uRepository.findAll();
	}

}
