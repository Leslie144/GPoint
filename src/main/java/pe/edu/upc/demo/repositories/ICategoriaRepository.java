package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	
	@Query (value = "select c.id_categoria, c.tipo_categoria, c.descripcion_categoria, sum(g.precio_juego) from categoria c join juego g on c.id_categoria=g.id_categoria group by c.id_categoria, c.tipo_categoria ,c.descripcion_categoria", nativeQuery = true)
	public List<String[]> GananciaTotalporCategoria();

}
