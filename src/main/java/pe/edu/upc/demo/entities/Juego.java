package pe.edu.upc.demo.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Juego")
public class Juego {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idJuego;

	@OneToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;

	@OneToOne
	@JoinColumn(name = "idClasificacion", nullable = false)
	private Clasificacion clasificacion;

	@OneToOne
	@JoinColumn(name = "idCalificacion", nullable = false)
	private Calificacion calificacion;

	@OneToOne
	@JoinColumn(name = "idPopularidad", nullable = false)
	private Popularidad popularidad;

	@Column(name = "nombreJuego", length = 30, nullable = false)
	private String nombreJuego;

	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;

	@Column(name = "fechaLanzamiento", nullable = false)
	private Date fechaLanzamiento;


	@Column(name = "tamanoJuego", nullable = false)
	private int tamanoJuego;

	@Column(name = "precioJuego", nullable = false)
	private float precioJuego;

	public Juego() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juego(int idJuego, Categoria categoria, Clasificacion clasificacion, Calificacion calificacion,
			Popularidad popularidad, String nombreJuego, String descripcion, Date fechaLanzamiento, int tamanoJuego,
			float precioJuego) {
		super();
		this.idJuego = idJuego;
		this.categoria = categoria;
		this.clasificacion = clasificacion;
		this.calificacion = calificacion;
		this.popularidad = popularidad;
		this.nombreJuego = nombreJuego;
		this.descripcion = descripcion;
		this.fechaLanzamiento = fechaLanzamiento;
		this.tamanoJuego = tamanoJuego;
		this.precioJuego = precioJuego;
	}

	public int getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(int idJuego) {
		this.idJuego = idJuego;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	public Calificacion getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Calificacion calificacion) {
		this.calificacion = calificacion;
	}

	public Popularidad getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(Popularidad popularidad) {
		this.popularidad = popularidad;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public int getTamanoJuego() {
		return tamanoJuego;
	}

	public void setTamanoJuego(int tamanoJuego) {
		this.tamanoJuego = tamanoJuego;
	}

	public float getPrecioJuego() {
		return precioJuego;
	}

	public void setPrecioJuego(float precioJuego) {
		this.precioJuego = precioJuego;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idJuego);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Juego other = (Juego) obj;
		return idJuego == other.idJuego;
	}


	

	
	
	

}
