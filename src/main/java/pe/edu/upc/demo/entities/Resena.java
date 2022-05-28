package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Resena")
public class Resena {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idResena;
	
	@Column(name = "mensaje", nullable = false, length = 200)
	private String mensaje;

	public Resena() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resena(int idResena, String mensaje) {
		super();
		this.idResena = idResena;
		this.mensaje = mensaje;
	}

	public int getIdResena() {
		return idResena;
	}

	public void setIdResena(int idResena) {
		this.idResena = idResena;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
	
	
}
