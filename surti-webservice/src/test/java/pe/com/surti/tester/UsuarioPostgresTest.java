package pe.com.surti.tester;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Usuario;
import pe.com.surti.service.ConsultaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class UsuarioPostgresTest {
	private final static Logger log = Logger.getLogger(UsuarioPostgresTest.class.getName());
	
	@Autowired
	private ConsultaService consultaService;
	
	@Test
	public void test(){
		try {
			//insertarUsuario();
			modificarUsuario();
			obtenerListaUsuario();	
			obtenerUsuarioPorLogo();
			obtenerUsuarioPorDni();
		} catch (Exception e) {
			log.error("No se pudo obtner la lista de usuarios: " + e);
		}
	}
	
	private void insertarUsuario() throws CustomException {
		consultaService.insertarUsuario(modelo());
	}
	
	private void modificarUsuario() throws CustomException {
		//consultaService.modificarUsuario(modelo());
	}
	
	private void obtenerListaUsuario() throws CustomException {
		consultaService.obtenerListaUsuario();
	}
	
	private void obtenerUsuarioPorLogo() throws CustomException {
		consultaService.obtenerUsuarioPorLogo("WCAHUAYA");
	}
	
	private void obtenerUsuarioPorDni() throws CustomException {
		consultaService.obtenerUsuarioPorDni("45656544");
	}
	
	
	private Usuario modelo(){
		int id = 8;
		Usuario u = new Usuario();
		u.setIdUsuario(id);
		u.setNombreCompleto("DEMO" + id);
		u.setDni("11111112");
		u.setEmail("cperez@gmail.com");
		u.setUsername("cperez" + id);
		u.setClave("cperez");
		u.setEstado("A");
		log.error("Usuarios de prueba: " + u);
		return u;
	}
}
