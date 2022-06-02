package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Galeria")
public class Galeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idGaleria;
	
	@Column(name = "nombreGaleria", nullable = false, length = 44 )
	private String nombreGaleria;
	
	@Column(name = "cantidadJuegos", nullable = false, length = 20 )
	private String cantidadJuegos;

	
	
	public Galeria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Galeria(int idGaleria, String nombreGaleria, String cantidadJuegos) {
		super();
		this.idGaleria = idGaleria;
		this.nombreGaleria = nombreGaleria;
		this.cantidadJuegos = cantidadJuegos;
	}

	
	
	
	public int getIdGaleria() {
		return idGaleria;
	}

	public void setIdGaleria(int idGaleria) {
		this.idGaleria = idGaleria;
	}

	public String getNombreGaleria() {
		return nombreGaleria;
	}

	public void setNombreGaleria(String nombreGaleria) {
		this.nombreGaleria = nombreGaleria;
	}

	public String getCantidadJuegos() {
		return cantidadJuegos;
	}

	public void setCantidadJuegos(String cantidadJuegos) {
		this.cantidadJuegos = cantidadJuegos;
	}
	
	
	
	
	
	
	
	

}
