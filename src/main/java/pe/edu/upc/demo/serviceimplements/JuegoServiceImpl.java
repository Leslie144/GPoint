package pe.edu.upc.demo.serviceimplements;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.demo.entities.Juego;
import pe.edu.upc.demo.repositories.IJuegoRepository;
import pe.edu.upc.demo.serviceinterface.IJuegoService;



@Service
public class JuegoServiceImpl implements IJuegoService {

	@Autowired
	private IJuegoRepository jR;

	

	@Override
	public List<Juego> list() {
		// TODO Auto-generated method stub
		return jR.findAll();
	}

	@Override
	public void insert(Juego j) {
		jR.save(j);
		
	}



}
