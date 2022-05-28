package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRol;
	
	@Column(name = "tipoRol", nullable = false, length = 30)
	private String tipoRol;

	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rol(int idRol, String tipoRol) {
		super();
		this.idRol = idRol;
		this.tipoRol = tipoRol;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
	
	
}
