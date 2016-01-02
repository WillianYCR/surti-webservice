package pe.com.surti.controller.response;

import pe.com.surti.controller.json.JsonUsuario;

public class ObtenerDatosUsuarioResponse {

	private JsonUsuario jsonUsuario;

	public JsonUsuario getJsonUsuario() {
		return jsonUsuario;
	}

	public void setJsonUsuario(JsonUsuario jsonUsuario) {
		this.jsonUsuario = jsonUsuario;
	}

	@Override
	public String toString() {
		return "ObtenerDatosUsuarioResponse [jsonUsuario=" + jsonUsuario + "]";
	}

}
