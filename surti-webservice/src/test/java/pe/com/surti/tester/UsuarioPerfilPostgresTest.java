package pe.com.surti.tester;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.UsuarioPerfil;
import pe.com.surti.service.ConsultaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class UsuarioPerfilPostgresTest {
	private final static Logger log = Logger.getLogger(UsuarioPerfilPostgresTest.class.getName());
	
	@Autowired
	private ConsultaService consultaService;
	
	@Test
	public void test(){
		try {
			//insertarUsuarioPerfil();
			modificarUsuarioPerfil();
			obtenerListaUsuarioPerfil();	
			obtenerUsuarioPerfilPorIdUsuario();
			obtenerUsuarioPerfilPorIdPerfil();
			obtenerUsuarioPerfilPorId();
		} catch (Exception e) {
			log.error("No se pudo obtner la lista de usuarios: " + e);
		}
	}
	
	private void insertarUsuarioPerfil() throws CustomException {
		consultaService.insertarUsuarioPerfil(modelo());
	}
	
	private void modificarUsuarioPerfil() throws CustomException {
		//consultaService.modificarUsuarioPerfil(modelo());
	}
	
	private void obtenerListaUsuarioPerfil() throws CustomException {
		consultaService.obtenerListaUsuarioPerfil();
	}
	
	private void obtenerUsuarioPerfilPorIdUsuario() throws CustomException {
		consultaService.obtenerListaUsuarioPerfilPorIdUsuario("4");
	}
	
	private void obtenerUsuarioPerfilPorIdPerfil() throws CustomException {
		consultaService.obtenerListaUsuarioPerfilPorIdPerfil("2");
	}
	
	private void obtenerUsuarioPerfilPorId() throws CustomException {
		consultaService.obtenerUsuarioPerfilPorId("2");
	}
	
	
	private UsuarioPerfil modelo(){
		UsuarioPerfil up = new UsuarioPerfil();
		up.setIdUsuarioPerfil(19);
		up.setIdUsuario(7);
		up.setIdPerfil(1);
		up.setEstado("A");
		log.error("Usuarios de prueba: " + up);
		return up;
	}
}
