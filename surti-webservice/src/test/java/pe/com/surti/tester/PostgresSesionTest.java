package pe.com.surti.tester;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Sesion;
import pe.com.surti.service.ConsultaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class PostgresSesionTest {
	private final static Logger log = Logger.getLogger(PostgresSesionTest.class
			.getName());

	@Autowired
	private ConsultaService consultaService;

	@Test
	public void test() {
		try {
			insertarUsuario();
			modificarSesion();
			obtenerListaSesion();
			obtenerSesionPorIdUsuario();
			obtenerSesionPorId();
		} catch (Exception e) {
			log.error(e);
		}
	}

	private void insertarUsuario() throws CustomException {
		consultaService.insertarSesion(modelo());
	}

	private void modificarSesion() throws CustomException {
		// consultaService.modificarSesion(modelo());
	}

	private void obtenerListaSesion() throws CustomException {
		consultaService.obtenerListaSesion();
	}

	private void obtenerSesionPorIdUsuario() throws CustomException {
		consultaService.obtenerSesionPorIdUsuario("1");
	}

	private void obtenerSesionPorId() throws CustomException {
		consultaService.obtenerSesionPorId("1");
	}

	private Sesion modelo() {
		int id = 3;
		long t = 500000;
		Timestamp time = new Timestamp(t);
		Sesion u = new Sesion();
		u.setIdSesion(id);
		u.setIdUsuario(2);
		u.setToken("DEMOTOKEN" + id);
		u.setFechaIngreso(time);
		u.setFechaFin(time);
		u.setEstadoLogico("0");
		log.error("Sesion de prueba: " + u);
		return u;
	}
}
