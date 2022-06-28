package pe.edu.upc.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);
	
	@Query(value = "SELECT us.id, us.username,  sum(t.precio_juego) from users us \r\n"
			+ "inner join transaccion t on t.id_usuario = us.id\r\n"
			+ "where us.fecha_registro >= (CURRENT_DATE - 30)\r\n"
			+ "group by us.id", nativeQuery = true)
	public List<String[]> quantityUsers();
}