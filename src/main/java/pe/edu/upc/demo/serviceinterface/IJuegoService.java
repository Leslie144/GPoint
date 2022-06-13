package pe.edu.upc.demo.serviceinterface;

import java.util.List;

import pe.edu.upc.demo.entities.Juego;



public interface IJuegoService {
	public void insert(Juego j);

	public List<Juego> list();

		

}
