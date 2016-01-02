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
public class PerfilPostgresTest {
	
	
	@Autowired
	private ConsultaService consultaService;
	
	@Test
	public void test() {
		try {
			//obtenerListaPerfil();	
			obtenerPerfilPorDescripcion();
			obtenerPerfilPorAbreviacion();
		} catch (Exception e) {
			System.out.println("No se pudo obtener la lista de los perfiles disponibles");
		}
	}

	private void obtenerListaPerfil() throws CustomException {
		consultaService.obtenerListaPerfil();
	}
	
	private void obtenerPerfilPorDescripcion() throws CustomException {
		consultaService.obtenerPerfilPorDescripcion("SISTEMAS");
	}
	
	private void obtenerPerfilPorAbreviacion() throws CustomException {
		consultaService.obtenerPerfilPorAbreviacion("ADM");
	}
}
