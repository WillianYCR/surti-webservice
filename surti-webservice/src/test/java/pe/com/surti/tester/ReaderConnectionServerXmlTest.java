package pe.com.surti.tester;

import org.junit.Test;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.common.xml.ReaderXml;

public class ReaderConnectionServerXmlTest {
	
	@Test
	public void test() throws CustomException {
		ReaderXml.startConnectionServerXML();
		System.out.println(ReaderXml.getConnectionXml().getId());
	}

}
