package pe.com.surti.tester;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Notificacion;
import pe.com.surti.service.ConsultaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class PostgresNotificacionTest {
	private final static Logger log = Logger
			.getLogger(PostgresNotificacionTest.class.getName());

	@Autowired
	private ConsultaService consultaService;

	@Test
	public void test() {
		try {
			insertarNotificacion();
			modificarNotificacion();
			obtenerListaNotificacion();
			obtenerNotificacionPorId();
		} catch (Exception e) {
			log.error(e);
		}
	}

	private void insertarNotificacion() throws CustomException {
		consultaService.insertarNotificacion(modelo());
	}

	private void modificarNotificacion() throws CustomException {
		// consultaService.modificarNotificacion(modelo());
	}

	private void obtenerListaNotificacion() throws CustomException {
		consultaService.obtenerListaNotificacion();
	}

	private void obtenerNotificacionPorId() throws CustomException {
		consultaService.obtenerNotificacionPorId("1");
	}

	private Notificacion modelo() {
		int id = 2;
		long t = 500000;
		Timestamp time = new Timestamp(t);
		Notificacion u = new Notificacion();
		u.setIdNotificacion(id);
		u.setRemitente("DEMO" + id);
		;
		u.setDestinatario("DEMO" + id);
		u.setAsunto("DEMO" + id);
		u.setFechaEnvio(time);
		u.setContenido("DEMO" + id);
		u.setLink("DEMO" + id);
		u.setEstadoNotificacion("A");
		u.setEstadoLogico("0");
		log.error("Notificacion de prueba: " + u);
		return u;
	}
}
