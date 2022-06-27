package pe.edu.upc.demo.serviceimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.demo.entities.DetalleResena;
import pe.edu.upc.demo.repositories.IDetalleResenaRepository;

import pe.edu.upc.demo.serviceinterface.IDetalleResenaService;

@Service
public class DetalleResenaServiceImpl implements IDetalleResenaService{
	
	@Autowired
	private IDetalleResenaRepository drR;
	

	@Override
	public void insert(DetalleResena dr) {
		// TODO Auto-generated method stub
		drR.save(dr);
	}

	@Override
	public List<DetalleResena> list() {
		// TODO Auto-generated method stub
		return drR.findAll();
	}

	@Override
	public void delete(int idDR) {
		drR.deleteById(idDR);
		
	}

	@Override
	@Transactional
	public void modificar(DetalleResena dr) {
		drR.save(dr);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DetalleResena> listarId(int idDr) {
		// TODO Auto-generated method stub
		return drR.findById(idDr);
	}

	
	
}
