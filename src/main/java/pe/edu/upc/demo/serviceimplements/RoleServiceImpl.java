package pe.edu.upc.demo.serviceimplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Role;
import pe.edu.upc.demo.repositories.IRoleRepository;
import pe.edu.upc.demo.serviceinterface.IRoleService;


@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleRepository rr;

	@Override
	public void insertar(Role r) {
		// TODO Auto-generated method stub
		rr.save(r);
	}

	@Override
	public List<Role> listar() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

}
