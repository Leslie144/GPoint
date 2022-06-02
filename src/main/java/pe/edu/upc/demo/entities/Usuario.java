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
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idUsuario;

	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false)
	private Rol rol;

	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 100, nullable = false)
	private String apellido;

	@Column(name = "username", length = 50, nullable = false)
	private String username;

	@Column(name = "contrasena", length = 10, nullable = false)
	private String contrasena;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaRegistro", nullable = false)
	private Date fechaRegistro;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaNacimiento", nullable = false)
	private Date fechaNacimiento;

	@Column(name = "correoUsuario", length = 50, nullable = false)
	private String correoUsuario;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int idUsuario, Rol rol, String nombre, String apellido, String username, String contrasena,
			Date fechaRegistro, Date fechaNacimiento, String correoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.rol = rol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.username = username;
		this.contrasena = contrasena;
		this.fechaRegistro = fechaRegistro;
		this.fechaNacimiento = fechaNacimiento;
		this.correoUsuario = correoUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, contrasena, correoUsuario, fechaNacimiento, fechaRegistro, idUsuario, nombre, rol,
				username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(contrasena, other.contrasena)
				&& Objects.equals(correoUsuario, other.correoUsuario)
				&& Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(fechaRegistro, other.fechaRegistro) && idUsuario == other.idUsuario
				&& Objects.equals(nombre, other.nombre) && Objects.equals(rol, other.rol)
				&& Objects.equals(username, other.username);
	}

	
}
