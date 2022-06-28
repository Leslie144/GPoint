package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Galeria;

@Repository
public interface IGaleriaRepository extends JpaRepository<Galeria, Integer>{

	
	@Query(value= "SELECT ga.nombre_galeria,COUNT(j.id_juego) FROM detalle_galeria g join juego j ON g.id_juego = j.id_juego join galeria ga ON ga.id_galeria = g.id_galeria GROUP BY ga.nombre_galeria", nativeQuery = true)
	public List<String[]>CantidadJuegosPorGaleria();

}
