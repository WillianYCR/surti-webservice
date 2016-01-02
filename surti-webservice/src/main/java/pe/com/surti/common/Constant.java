package pe.com.surti.common;

public interface Constant {

	interface Xml {
		String FICHERO_FORMATO_ERROR = "El formato XML del fichero es incorrecto\n";
		String FICHERO_LECTURA_ERROR = "Se puede leer el fichero\n";
		String FICHERO_CREAR_ERROR = "No se puede crear el documento XML\n";
	}
	
	interface Properties{
		String MF101 = "No se cerró la instance de InputStream";
		String MF102 = "Error al instanciar la Clase FileInputStream";
	}
	
	interface rutaFile{
		String XML_CONNECTION = "src/main/resources/connectionServer.xml";
		String PROPERTIES_MESSAGE = "src/main/resources/message-spanish.properties";
		String PROPERTIES_LOG4J = "src/main/resources/log4j.properties";
	}

}
