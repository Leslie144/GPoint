/**
 * 
 */
package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Leslie
 *
 */
@Entity
@Table(name = "Categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCategoria;

	@Column(name = "tipoCategoria", nullable = false, length = 50)
	private String tipoCategoria;
	
	@Column(name = "descripcionCategoria", nullable = false, length = 100)
	private String descripcionCategoria;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int idCategoria, String tipoCategoria, String descripcionCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.tipoCategoria = tipoCategoria;
		this.descripcionCategoria = descripcionCategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	
	
}
