package pe.edu.upc.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetalleGaleria")
public class DetalleGaleria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDetalleGaleria;
	
	@ManyToOne
	@JoinColumn(name = "idJuego", nullable = false)
	private Juego juego;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Users usuario;

	public DetalleGaleria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetalleGaleria(int idDetalleGaleria, Juego juego, Users usuario) {
		super();
		this.idDetalleGaleria = idDetalleGaleria;
		this.juego = juego;
		this.usuario = usuario;
	}

	public int getIdDetalleGaleria() {
		return idDetalleGaleria;
	}

	public void setIdDetalleGaleria(int idDetalleGaleria) {
		this.idDetalleGaleria = idDetalleGaleria;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	

	
}
