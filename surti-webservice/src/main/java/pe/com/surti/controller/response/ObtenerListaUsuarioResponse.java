package pe.com.surti.controller.response;

import java.util.List;

import pe.com.surti.controller.json.JsonUsuario;

public class ObtenerListaUsuarioResponse {

	private List<JsonUsuario> jsonUsuario;

	public List<JsonUsuario> getJsonUsuario() {
		return jsonUsuario;
	}

	public void setJsonUsuario(List<JsonUsuario> jsonUsuario) {
		this.jsonUsuario = jsonUsuario;
	}

	@Override
	public String toString() {
		return "ObtenerListaUsuarioResponse [jsonUsuario=" + jsonUsuario + "]";
	}

}
