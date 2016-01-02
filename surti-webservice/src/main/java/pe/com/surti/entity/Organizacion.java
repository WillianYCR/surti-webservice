package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "ORGANIZACION" database table.
 * 
 */
@Entity
@Table(name = "\"ORGANIZACION\"")
@NamedQuery(name = "Organizacion.findAll", query = "SELECT o FROM Organizacion o")
public class Organizacion extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"idOrganizacion\"", unique = true, nullable = false)
	private Integer idOrganizacion;

	@Column(nullable = false, length = 50)
	private String descripcion;

	@Column(name = "\"descripcionComercial\"", length = 50)
	private String descripcionComercial;

	@Column(name = "\"descripcionSocial\"", length = 50)
	private String descripcionSocial;

	@Column(length = 200)
	private String detalle;

	@Column(length = 100)
	private String direccion;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false, length = 1)
	private String estado;

	@Column(length = 11)
	private String ruc;

	@Column(length = 20)
	private String telefono;

	public Organizacion() {
	}

	public Integer getIdOrganizacion() {
		return this.idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionComercial() {
		return this.descripcionComercial;
	}

	public void setDescripcionComercial(String descripcionComercial) {
		this.descripcionComercial = descripcionComercial;
	}

	public String getDescripcionSocial() {
		return this.descripcionSocial;
	}

	public void setDescripcionSocial(String descripcionSocial) {
		this.descripcionSocial = descripcionSocial;
	}

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Organizacion [idOrganizacion=" + idOrganizacion
				+ ", descripcion=" + descripcion + ", descripcionComercial="
				+ descripcionComercial + ", descripcionSocial="
				+ descripcionSocial + ", detalle=" + detalle + ", direccion="
				+ direccion + ", email=" + email + ", estado=" + estado
				+ ", ruc=" + ruc + ", telefono=" + telefono + "]";
	}

}