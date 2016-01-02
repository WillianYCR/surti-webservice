package pe.com.surti.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import pe.com.surti.app.ConexionManager;
import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Parametro;
import pe.com.surti.service.SoporteService;

@Controller
public class SoporteSistema {

	private final static Logger log = Logger.getLogger(ConexionManager.class
			.getName());

	@Autowired
	private SoporteService soporteService;
	/*
	 * public void registrarParametro(Parametro parametro)throws
	 * CustomException{ log.info("Accedio a los servicios");
	 * //soporteService.registrarParametro(parametro);
	 * 
	 * }
	 */
}
