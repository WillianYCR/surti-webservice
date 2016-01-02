package pe.com.surti.controller.request;

import java.io.Serializable;

public class ObtenerDatosUsuarioRequest implements Serializable {

  private static final long serialVersionUID = 1L;

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
