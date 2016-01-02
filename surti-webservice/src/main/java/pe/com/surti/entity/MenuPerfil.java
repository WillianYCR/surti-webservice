package pe.com.surti.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the "MENU_PERFIL" database table.
 * 
 */
@Entity
@Table(name = "\"MENU_PERFIL\"")
@NamedQuery(name = "MenuPerfil.findAll", query = "SELECT m FROM MenuPerfil m")
public class MenuPerfil extends EntityBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "\"idMenuPerfil\"", unique = true, nullable = false)
	private Integer idMenuPerfil;

	@Column(nullable = false, length = 1)
	private String estado;

	@Column(name = "\"idMenu\"", nullable = false)
	private Integer idMenu;

	@Column(name = "\"idPerfil\"", nullable = false)
	private Integer idPerfil;

	public MenuPerfil() {
	}

	public Integer getIdMenuPerfil() {
		return this.idMenuPerfil;
	}

	public void setIdMenuPerfil(Integer idMenuPerfil) {
		this.idMenuPerfil = idMenuPerfil;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public Integer getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	@Override
	public String toString() {
		return "MenuPerfil [idMenuPerfil=" + idMenuPerfil + ", estado="
				+ estado + ", idMenu=" + idMenu + ", idPerfil=" + idPerfil
				+ "]";
	}

}