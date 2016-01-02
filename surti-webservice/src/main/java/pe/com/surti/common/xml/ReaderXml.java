package pe.com.surti.common.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pe.com.surti.common.Constant;
import pe.com.surti.common.exception.CustomException;

public class ReaderXml {

	private final static Logger log = Logger.getLogger(ReaderXml.class
			.getName());
	
	private static ConnectionServerXml connServXML;
	
	public static void startConnectionServerXML() throws CustomException {
		connectionServerXML(Constant.rutaFile.XML_CONNECTION);
	}
	
	public static ConnectionServerXml getConnectionXml() {
		return connServXML;
	}

	private static void connectionServerXML(String file)
			throws CustomException {
		JAXBContext jaxCont;
		Unmarshaller shall;
		try {
			jaxCont = JAXBContext.newInstance(ConnectionServerXml.class);
			shall = jaxCont.createUnmarshaller();
			connServXML = (ConnectionServerXml) shall.unmarshal(new File(file));
			log.info(connServXML);
		} catch (JAXBException e) {
			log.error(e.getMessage());
		}
	}
	
	@SuppressWarnings("unused")
	private static void getXml(String nameTag) throws CustomException {
		getXml(nameTag, Constant.rutaFile.XML_CONNECTION);
	}

	private static void getXml(String nameTag, String rutaDoc) {
		try {
			StringBuilder VALOR_XML = null;
			VALOR_XML = new StringBuilder();
			DocumentBuilderFactory fabricaDoc;
			DocumentBuilder crearDoc;
			Document doc;
			Element raizEle;

			fabricaDoc = DocumentBuilderFactory.newInstance();
			crearDoc = fabricaDoc.newDocumentBuilder();
			doc = crearDoc.parse(rutaDoc);
			raizEle = doc.getDocumentElement();
			NodeList listaTagPri = raizEle.getElementsByTagName(nameTag);

			for (int i = 0; i < listaTagPri.getLength(); i++) {
				Node nodoPri = listaTagPri.item(i);
				NodeList listaTagSec = nodoPri.getChildNodes();

				for (int j = 0; j < listaTagSec.getLength(); j++) {
					Node nodoSec = listaTagSec.item(j);

					if (nodoSec.getNodeType() == Node.ELEMENT_NODE) {
						Node dato = nodoSec.getFirstChild();
						VALOR_XML.append(nodoSec.getNodeName() + ": ");
						if (dato != null
								&& dato.getNodeType() == Node.TEXT_NODE) {
							VALOR_XML.append(dato.getNodeValue() + "\n");
						}
					}
				}
			}
			log.info(VALOR_XML);
		} catch (SAXException ex) {
			log.error(Constant.Xml.FICHERO_FORMATO_ERROR);
			ex.printStackTrace();
		} catch (IOException ex) {
			log.error(Constant.Xml.FICHERO_FORMATO_ERROR);
			ex.printStackTrace();
		} catch (ParserConfigurationException ex) {
			log.error(Constant.Xml.FICHERO_CREAR_ERROR);
			ex.printStackTrace();
		}

	}
}
