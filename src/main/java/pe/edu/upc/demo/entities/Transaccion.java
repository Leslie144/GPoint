package pe.edu.upc.demo.entities;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table (name="Transaccion")
public class Transaccion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTransaccion;
	
	@ManyToOne
	@JoinColumn(name = "idJuego", nullable = false)
	private Juego juego;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Users usuario;
	
	@Column(name="precioJuego", nullable = false)
	private int precioJuego;
	
	@Column(name="fechaTransaccion", nullable = false)
	private Date fechaTransaccion;

	
	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaccion(int id, Juego juego, Users usuario, int precioJuego, Date fechaTransaccion) {
		super();
		this.idTransaccion = id;
		this.juego = juego;
		this.usuario = usuario;
		this.precioJuego = precioJuego;
		this.fechaTransaccion = fechaTransaccion;
	}

	//GETTERS & SETTERS
	
	public int getIdTransaccion() {
		return idTransaccion;
	}


	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
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


	public int getPrecioJuego() {
		return precioJuego;
	}


	public void setPrecioJuego(int precioJuego) {
		this.precioJuego = precioJuego;
	}


	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}


	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}


	
}
