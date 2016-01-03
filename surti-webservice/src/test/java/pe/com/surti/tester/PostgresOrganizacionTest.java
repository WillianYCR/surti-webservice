package pe.com.surti.tester;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Organizacion;
import pe.com.surti.service.ConsultaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class PostgresOrganizacionTest {
	private final static Logger log = Logger
			.getLogger(PostgresOrganizacionTest.class.getName());

	@Autowired
	private ConsultaService consultaService;

	@Test
	public void test() {
		try {
			// insertarOrganizacion();
			modificarOrganizacion();
			obtenerListaOrganizacion();
			obtenerOrganizacionPorId();
		} catch (Exception e) {
			log.error(e);
		}
	}

	private void insertarOrganizacion() throws CustomException {
		consultaService.insertarOrganizacion(modelo());
	}

	private void modificarOrganizacion() throws CustomException {
		// consultaService.modificarOrganizacion(modelo());
	}

	private void obtenerListaOrganizacion() throws CustomException {
		consultaService.obtenerListaOrganizacion();
	}

	private void obtenerOrganizacionPorId() throws CustomException {
		consultaService.obtenerOrganizacionPorId("1");
	}

	private Organizacion modelo() {
		int id = 3;
		Organizacion up = new Organizacion();
		up.setIdOrganizacion(id);
		up.setDescripcion("DEMO" + id);
		up.setDescripcionSocial("DEMO" + id);
		up.setDescripcionComercial("DEMO" + id);
		up.setRuc("999999" + id);
		up.setDireccion("DEMO" + id);
		up.setTelefono("99999999" + id);
		up.setEmail("DEMO" + id);
		up.setDetalle("DEMO" + id);
		up.setEstado("A");
		log.error("Usuarios de prueba: " + up);
		return up;
	}
}
