package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the "SESION" database table.
 * 
 */
@Entity
@Table(name = "\"SESION\"")
@NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s")
public class Sesion extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"idSesion\"", unique = true, nullable = false)
	private Integer idSesion;

	@Column(name = "\"estadoLogico\"", nullable = false, length = 1)
	private String estadoLogico;

	@Column(name = "\"fechaFin\"", nullable = false)
	private Timestamp fechaFin;

	@Column(name = "\"fechaIngreso\"", nullable = false)
	private Timestamp fechaIngreso;

	@Column(name = "\"idUsuario\"", nullable = false)
	private Integer idUsuario;

	@Column(nullable = false, length = 50)
	private String token;

	public Sesion() {
	}

	public Integer getIdSesion() {
		return this.idSesion;
	}

	public void setIdSesion(Integer idSesion) {
		this.idSesion = idSesion;
	}

	public String getEstadoLogico() {
		return this.estadoLogico;
	}

	public void setEstadoLogico(String estadoLogico) {
		this.estadoLogico = estadoLogico;
	}

	public Timestamp getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Timestamp getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Sesion [idSesion=" + idSesion + ", estadoLogico="
				+ estadoLogico + ", fechaFin=" + fechaFin + ", fechaIngreso="
				+ fechaIngreso + ", idUsuario=" + idUsuario + ", token="
				+ token + "]";
	}

}