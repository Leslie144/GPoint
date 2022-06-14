package pe.edu.upc.demo.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table (name="Notificacion")
public class Notificacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idNotificacion;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false)
	private Users usuario;
	
	@ManyToOne
	@JoinColumn(name = "idJuego", nullable = false)
	private Juego juego;
	
	@Column(name="mensaje", nullable = false, length = 44)
	private String mensaje;
	
	@Column(name="notificacionActiva", nullable = false, length = 44)
	private String notificacionActiva;

	
	public Notificacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notificacion(int id, Users usuario, Juego juego,  String mensaje, String notificacionActiva) {
		super();
		this.idNotificacion = id;
		this.usuario = usuario;
		this.juego = juego;
		this.mensaje = mensaje;
		this.notificacionActiva = notificacionActiva;
	}

	//GETTERS & SETTERS
	
	public int getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(int idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getNotificacionActiva() {
		return notificacionActiva;
	}

	public void setNotificacionActiva(String notificacionActiva) {
		this.notificacionActiva = notificacionActiva;
	}
	
	
	
}
