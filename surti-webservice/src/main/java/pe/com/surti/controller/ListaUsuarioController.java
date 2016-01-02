package pe.com.surti.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.controller.json.JsonUsuario;
import pe.com.surti.controller.response.ObtenerListaUsuarioResponse;
import pe.com.surti.entity.Usuario;
import pe.com.surti.service.ConsultaService;

@RestController
public class ListaUsuarioController {
	private final static Logger log = Logger.getLogger(ListaUsuarioController.class
			.getName());

	@Autowired
	private ConsultaService consultaService;

	@RequestMapping(value = "/obtenerListaUsuario", method = RequestMethod.GET)
	public ObtenerListaUsuarioResponse obtenerListaUsuario() {
		log.debug("Inicio de proceso Rest");
		ObtenerListaUsuarioResponse response;
		List<Usuario> listaUsuario;

		response = new ObtenerListaUsuarioResponse();
		try {
			listaUsuario = consultaService.obtenerListaUsuario();
			response.setJsonUsuario(formatearJson(listaUsuario));
			log.debug("Respuesta [" + response.toString() + "]");
		} catch (CustomException e) {
			log.debug("Salio catch");
			e.printStackTrace();
		}

		return response;
	}
	
	private List<JsonUsuario> formatearJson(List<Usuario> listaUsuario){
		List<JsonUsuario> lista;
		JsonUsuario jsonUsuario;
		
		lista = new ArrayList<JsonUsuario>();
		
		for(Usuario u : listaUsuario){
			jsonUsuario = new JsonUsuario();
			jsonUsuario.setIdUsuario(u.getIdUsuario());
			jsonUsuario.setNombreCompleto(u.getNombreCompleto());
			jsonUsuario.setUsername(u.getUsername());
			lista.add(jsonUsuario);
		}
		return lista;
	}
}
