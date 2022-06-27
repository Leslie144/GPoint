package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.demo.entities.DetalleResena;




public interface IDetalleResenaService {
	
	public void insert(DetalleResena dr);

	public List<DetalleResena> list();

	public void delete(int idDR);
	
	public void modificar(DetalleResena dr);
	
	Optional<DetalleResena> listarId(int idDr);
}
