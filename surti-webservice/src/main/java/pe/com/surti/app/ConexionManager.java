package pe.com.surti.app;

import org.apache.log4j.Logger;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.common.properties.FileProperties;
import pe.com.surti.common.xml.ReaderXml;

public class ConexionManager {

	private final static Logger log = Logger.getLogger(ConexionManager.class
			.getName());

	public static void startConexionSystem() throws CustomException {
		log.debug("Cargando datos de inicio para el sistema...");
		FileProperties.startMessageProperties();
		ReaderXml.startConnectionServerXML();
		log.debug("Datos cargados correctamente...");
	}

	public static void cerrandoConexionAlSistema() throws CustomException {
		log.debug("Cerrando conexion del sistema...");
	}
}
