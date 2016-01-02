package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "PARAMETRO" database table.
 * 
 */
@Entity
@Table(name="\"PARAMETRO\"")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idParametro\"", unique=true, nullable=false)
	private Integer idParametro;

	@Column(nullable=false, length=50)
	private String descripcion;

	@Column(length=200)
	private String detalle;

	@Column(nullable=false, length=1)
	private String estado;

	@Column(length=10)
	private String valor;

	@Column(name="\"valorDefecto\"", length=10)
	private String valorDefecto;

	public Parametro() {
	}

	public Integer getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
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

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValorDefecto() {
		return this.valorDefecto;
	}

	public void setValorDefecto(String valorDefecto) {
		this.valorDefecto = valorDefecto;
	}

	@Override
	public String toString() {
		return "Parametro [idParametro=" + idParametro + ", descripcion="
				+ descripcion + ", detalle=" + detalle + ", estado=" + estado
				+ ", valor=" + valor + ", valorDefecto=" + valorDefecto + "]";
	}
	
	

}