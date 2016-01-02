package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "MENU" database table.
 * 
 */
@Entity
@Table(name = "\"MENU\"")
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
public class Menu extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"idMenu\"", unique = true, nullable = false)
	private Integer idMenu;

	@Column(name = "\"codigoPagina\"", length = 10)
	private String codigoPagina;

	@Column(nullable = false, length = 50)
	private String descripcion;

	@Column(length = 200)
	private String detalle;

	@Column(nullable = false, length = 1)
	private String estado;

	@Column(name = "\"idMenuPadre\"")
	private Integer idMenuPadre;

	@Column(nullable = false)
	private Integer nivel;

	@Column(nullable = false)
	private Integer orden;

	public Menu() {
	}

	public Integer getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getCodigoPagina() {
		return this.codigoPagina;
	}

	public void setCodigoPagina(String codigoPagina) {
		this.codigoPagina = codigoPagina;
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

	public Integer getIdMenuPadre() {
		return this.idMenuPadre;
	}

	public void setIdMenuPadre(Integer idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}

	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", codigoPagina=" + codigoPagina
				+ ", descripcion=" + descripcion + ", detalle=" + detalle
				+ ", estado=" + estado + ", idMenuPadre=" + idMenuPadre
				+ ", nivel=" + nivel + ", orden=" + orden + "]";
	}

}