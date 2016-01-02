package pe.com.surti.tester;

import org.junit.Test;

import pe.com.surti.common.properties.FileProperties;

public class ReaderMessagePropertiesTest {
	@Test
	public void test() throws Exception {
		FileProperties.startMessageProperties();
		System.out.println(FileProperties.getMessage().getM1001());
	}
}
