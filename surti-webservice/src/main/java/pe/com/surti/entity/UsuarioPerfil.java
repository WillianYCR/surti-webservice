package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "USUARIO_PERFIL" database table.
 * 
 */
@Entity
@Table(name = "\"USUARIO_PERFIL\"")
@NamedQuery(name = "UsuarioPerfil.findAll", query = "SELECT u FROM UsuarioPerfil u")
public class UsuarioPerfil extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"idUsuarioPerfil\"", unique = true, nullable = false)
	private Integer idUsuarioPerfil;

	@Column(nullable = false, length = 1)
	private String estado;

	@Column(name = "\"idPerfil\"", nullable = false)
	private Integer idPerfil;

	@Column(name = "\"idUsuario\"", nullable = false)
	private Integer idUsuario;

	public UsuarioPerfil() {
	}

	public Integer getIdUsuarioPerfil() {
		return this.idUsuarioPerfil;
	}

	public void setIdUsuarioPerfil(Integer idUsuarioPerfil) {
		this.idUsuarioPerfil = idUsuarioPerfil;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "UsuarioPerfil [idUsuarioPerfil=" + idUsuarioPerfil
				+ ", estado=" + estado + ", idPerfil=" + idPerfil
				+ ", idUsuario=" + idUsuario + "]";
	}

}