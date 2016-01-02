package pe.com.surti.common.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import pe.com.surti.common.Constant;
import pe.com.surti.common.exception.CustomException;

public class ReaderProperties {
	
	protected static String getLog4j() throws CustomException {
		return Constant.rutaFile.PROPERTIES_LOG4J;
	}
	
	protected static Properties getProperties(String ruta)
			throws CustomException {
		Properties properties;
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(ruta);
			properties = new Properties();
			properties.load(inStream);
			return properties;
		} catch (IOException ioe) {
			throw new CustomException(Constant.Properties.MF102);
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException io) {
					throw new CustomException(Constant.Properties.MF101);
				}
			}
		}
	}
}
