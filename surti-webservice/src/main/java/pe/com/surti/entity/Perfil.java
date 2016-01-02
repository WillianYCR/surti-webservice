package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "PERFIL" database table.
 * 
 */
@Entity
@Table(name="\"PERFIL\"")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idPerfil\"", unique=true, nullable=false)
	private Integer idPerfil;

	@Column(nullable=false, length=3)
	private String abreviacion;

	@Column(nullable=false, length=20)
	private String descripcion;

	@Column(length=200)
	private String detalle;

	@Column(nullable=false, length=1)
	private String estado;

	public Perfil() {
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getAbreviacion() {
		return this.abreviacion;
	}

	public void setAbreviacion(String abreviacion) {
		this.abreviacion = abreviacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Perfil [idPerfil=" + idPerfil + ", abreviacion=" + abreviacion
				+ ", descripcion=" + descripcion + ", detalle=" + detalle
				+ ", estado=" + estado + "]";
	}
	
}