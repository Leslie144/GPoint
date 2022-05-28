package pe.edu.upc.demo.serviceinterface;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.demo.entities.Rol;

public interface IRolService {

	public void insert(Rol rol);

	public List<Rol> list();

	public void delete(int idRol);

	Optional<Rol> listId(int idRol);

	public void update(Rol rol);
}
