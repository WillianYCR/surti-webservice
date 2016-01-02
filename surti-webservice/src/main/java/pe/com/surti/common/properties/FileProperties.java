package pe.com.surti.common.properties;

import java.util.Properties;

import org.apache.log4j.Logger;

import pe.com.surti.common.Constant;
import pe.com.surti.common.exception.CustomException;

public class FileProperties extends ReaderProperties{

	private final static Logger log = Logger.getLogger(FileProperties.class
			.getName());
	private static MessageProperties messageProp;
	
	public static void startMessageProperties() throws CustomException {
		capturaMessage(getProperties(Constant.rutaFile.PROPERTIES_MESSAGE));
	}
	
	public static MessageProperties getMessage() {
		return messageProp;
	}

	private static MessageProperties capturaMessage(Properties prop){
		messageProp = new MessageProperties();
		messageProp.setM1001(prop.getProperty("M1001"));
		messageProp.setM1002(prop.getProperty("M1002"));
		messageProp.setM1003(prop.getProperty("M1003"));
		log.info(messageProp);
		return messageProp;
	}
}
