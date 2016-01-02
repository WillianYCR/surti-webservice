package pe.com.surti.tester;

import org.junit.Test;

import pe.com.surti.app.ConexionManager;
import pe.com.surti.common.exception.CustomException;

public class SpringContextTest {
	@Test
	public void test() throws CustomException {
		ConexionManager.startConexionSystem();
	}
}
