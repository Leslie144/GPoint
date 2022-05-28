package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Rol;
import pe.edu.upc.demo.repositories.IRolRepository;
import pe.edu.upc.demo.serviceinterface.IRolService;

@Service
public class RolServiceImpl implements IRolService{
	
	@Autowired
	private IRolRepository rolRepository;
	 
	@Override
	public void insert(Rol rol) {
		rolRepository.save(rol);
		
	}

	@Override
	public List<Rol> list() {
		
		return rolRepository.findAll();
	}

	@Override
	public void delete(int idRol) {
		rolRepository.deleteById(idRol);
		
	}

	@Override
	public Optional<Rol> listId(int idRol) {
		
		return rolRepository.findById(idRol);
	}

	@Override
	public void update(Rol rol) {
		rolRepository.save(rol);
		
	}

}
