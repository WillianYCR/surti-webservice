package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "USUARIO" database table.
 * 
 */
@Entity
@Table(name="\"USUARIO\"")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idUsuario\"", unique=true, nullable=false)
	private Integer idUsuario;

	@Column(nullable=false, length=50)
	private String clave;

	@Column(nullable=false, length=8)
	private String dni;

	@Column(nullable=false, length=100)
	private String email;

	@Column(nullable=false, length=1)
	private String estado;

	@Column(name="\"nombreCompleto\"", nullable=false, length=100)
	private String nombreCompleto;

	@Column(nullable=false, length=20)
	private String username;

	public Usuario() {
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", clave=" + clave
				+ ", dni=" + dni + ", email=" + email + ", estado=" + estado
				+ ", nombreCompleto=" + nombreCompleto + ", username="
				+ username + "]";
	}

}