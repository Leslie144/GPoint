package pe.edu.upc.demo.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DetalleResenas")
public class DetalleResena {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDetalleResena;
	
	@ManyToOne
	@JoinColumn(name = "idResena", nullable = false)
	private Resena resena;

	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private Users usuario;

	@ManyToOne
	@JoinColumn(name = "idJuego", nullable = false)
	private Juego juego;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaPublicacion", nullable = false)
	private Date fechaPublicacion;

	public DetalleResena() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DetalleResena(int id, Resena resena, Users usuario, Juego juego, Date fechaPublicacion) {
		super();
		this.idDetalleResena = id;
		this.resena = resena;
		this.usuario = usuario;
		this.juego = juego;
		this.fechaPublicacion = fechaPublicacion;
	}



	public int getIdDetalleResena() {
		return idDetalleResena;
	}



	public void setIdDetalleResena(int idDetalleResena) {
		this.idDetalleResena = idDetalleResena;
	}



	public Resena getResena() {
		return resena;
	}



	public void setResena(Resena resena) {
		this.resena = resena;
	}



	public Users getUsuario() {
		return usuario;
	}



	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}



	public int getId() {
		return idDetalleResena;
	}

	

	public Juego getJuego() {
		return juego;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setId(int id) {
		this.idDetalleResena = id;
	}

	

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idDetalleResena);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleResena other = (DetalleResena) obj;
		return idDetalleResena == other.idDetalleResena;
	}

	
	
}
