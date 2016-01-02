package pe.com.surti.controller.request;

public class ObtenerDatosUsuarioRequest {
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "ObtenerDatosUsuarioRequest [username=" + username + "]";
	}

}
