package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the "NOTIFICACION" database table.
 * 
 */
@Entity
@Table(name="\"NOTIFICACION\"")
@NamedQuery(name="Notificacion.findAll", query="SELECT n FROM Notificacion n")
public class Notificacion extends EntityBase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="\"idNotificacion\"", unique=true, nullable=false)
	private Integer idNotificacion;

	@Column(nullable=false, length=20)
	private String asunto;

	@Column(nullable=false, length=500)
	private String contenido;

	@Column(nullable=false, length=100)
	private String destinatario;

	@Column(name="\"estadoLogico\"", length=1)
	private String estadoLogico;

	@Column(name="\"estadoNotificacion\"", nullable=false, length=1)
	private String estadoNotificacion;

	@Column(name="\"fechaEnvio\"", nullable=false)
	private Timestamp fechaEnvio;

	@Column(length=100)
	private String link;

	@Column(nullable=false, length=100)
	private String remitente;

	public Notificacion() {
	}

	public Integer getIdNotificacion() {
		return this.idNotificacion;
	}

	public void setIdNotificacion(Integer idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getDestinatario() {
		return this.destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getEstadoLogico() {
		return this.estadoLogico;
	}

	public void setEstadoLogico(String estadoLogico) {
		this.estadoLogico = estadoLogico;
	}

	public String getEstadoNotificacion() {
		return this.estadoNotificacion;
	}

	public void setEstadoNotificacion(String estadoNotificacion) {
		this.estadoNotificacion = estadoNotificacion;
	}

	public Timestamp getFechaEnvio() {
		return this.fechaEnvio;
	}

	public void setFechaEnvio(Timestamp fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRemitente() {
		return this.remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	@Override
	public String toString() {
		return "Notificacion [idNotificacion=" + idNotificacion + ", asunto="
				+ asunto + ", contenido=" + contenido + ", destinatario="
				+ destinatario + ", estadoLogico=" + estadoLogico
				+ ", estadoNotificacion=" + estadoNotificacion
				+ ", fechaEnvio=" + fechaEnvio + ", link=" + link
				+ ", remitente=" + remitente + "]";
	}

}