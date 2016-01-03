package pe.com.surti.tester;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.service.ConsultaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class PostgresParametroTest {

	@Autowired
	private ConsultaService consultaService;

	@Test
	public void test() throws CustomException {
		listByEstado();
		obtenerParametroPorDescripcion();
	}

	private void listByEstado() throws CustomException {
		consultaService.listByEstado("A");
	}

	private void obtenerParametroPorDescripcion() throws CustomException {
		consultaService.obtenerParametroPorDescripcion("TIEMPOVIDATOKEN");
	}
}
