package pe.com.surti.tester;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.service.ConsultaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class PostgresMenuPerfilTest {
	private final static Logger log = Logger.getLogger(PostgresMenuPerfilTest.class.getName());
	
	@Autowired
	private ConsultaService consultaService;
	
	@Test
	public void test(){
		try {
			obtenerListaMenuPerfil();	
			obtenerMenuPerfilPorId();
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	private void obtenerListaMenuPerfil() throws CustomException {
		consultaService.obtenerListaMenuPerfil();
	}
	
	private void obtenerMenuPerfilPorId() throws CustomException {
		consultaService.obtenerMenuPerfilPorId("2");
	}
}
