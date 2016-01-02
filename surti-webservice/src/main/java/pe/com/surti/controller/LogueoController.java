package pe.com.surti.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.controller.json.JsonUsuario;
import pe.com.surti.controller.request.ObtenerDatosUsuarioRequest;
import pe.com.surti.controller.response.ObtenerDatosUsuarioResponse;
import pe.com.surti.entity.Usuario;
import pe.com.surti.service.ConsultaService;

@RestController
public class LogueoController {
	private final static Logger log = Logger.getLogger(LogueoController.class
			.getName());

	@Autowired
	private ConsultaService consultaService;

	@RequestMapping(value = "/obtenerUsuarioPorLogo", method = RequestMethod.POST)
	public ObtenerDatosUsuarioResponse obtenerUsuarioPorLogo(String username) {
		log.debug("Inicio de proceso Rest");
		ObtenerDatosUsuarioResponse response;
		Usuario usuario;

		response = new ObtenerDatosUsuarioResponse();
		try {
			usuario = consultaService.obtenerUsuarioPorLogo(username);
			response.setJsonUsuario(formatearJson(usuario));
			log.debug("Respuesta [" + response + "]");
		} catch (CustomException e) {
			e.printStackTrace();
		}

		return response;
	}
	
	private JsonUsuario formatearJson(Usuario usuario){
		JsonUsuario jsonUsuario = new JsonUsuario();
		jsonUsuario.setIdUsuario(usuario.getIdUsuario());
		jsonUsuario.setNombreCompleto(usuario.getNombreCompleto());
		jsonUsuario.setUsername(usuario.getUsername());
		return jsonUsuario;
	}

}
