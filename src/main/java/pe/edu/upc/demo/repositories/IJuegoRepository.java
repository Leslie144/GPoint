package pe.edu.upc.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Juego;

@Repository
public interface IJuegoRepository extends JpaRepository<Juego, Integer> {
	@Query("select count(j.nombreJuego) from Juego j where j.nombreJuego =:nombreJuego")
	public int buscarNombreJuego(@Param("nombreJuego") String nombreJuego);
}
