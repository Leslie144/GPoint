package pe.edu.upc.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name="Calificacion")
public class Calificacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCalificacion;
	
	@Column(name="numEstrellas", nullable = false, length = 44)
	private String numEstrellas;

	
	public Calificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//GETTERS & SETTERS

	public int getIdCalificacion() {
		return idCalificacion;
	}


	public void setIdCalificacion(int idCalificacion) {
		this.idCalificacion = idCalificacion;
	}


	public String getNumEstrellas() {
		return numEstrellas;
	}


	public void setNumEstrellas(String numEstrellas) {
		this.numEstrellas = numEstrellas;
	}

	
}
