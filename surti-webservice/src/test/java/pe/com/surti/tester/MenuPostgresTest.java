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
public class MenuPostgresTest {
	private final static Logger log = Logger.getLogger(MenuPostgresTest.class.getName());
	
	@Autowired
	private ConsultaService consultaService;
	
	@Test
	public void test(){
		try {
			obtenerListaMenu();
			obtenerMenuPorId();
		} catch (Exception e) {
			log.error("No se pudo obtner la lista de usuarios: " + e);
		}
	}
	
	private void obtenerListaMenu() throws CustomException {
		consultaService.obtenerListaMenu();
	}
	
	private void obtenerMenuPorId() throws CustomException {
		consultaService.obtenerMenuPorId("5");
	}
	
}