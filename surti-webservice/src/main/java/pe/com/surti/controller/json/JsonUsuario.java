package pe.com.surti.controller.json;

public class JsonUsuario {

	private Integer idUsuario;
	private String nombreCompleto;
	private String username;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "JsonUsuario [idUsuario=" + idUsuario + ", nombreCompleto="
				+ nombreCompleto + ", username=" + username + "]";
	}

}
