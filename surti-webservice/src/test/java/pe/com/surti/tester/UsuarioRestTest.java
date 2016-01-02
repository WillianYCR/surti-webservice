package pe.com.surti.tester;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.controller.ListaUsuarioController;
import pe.com.surti.controller.LogueoController;
import pe.com.surti.controller.response.ObtenerDatosUsuarioResponse;
import pe.com.surti.controller.response.ObtenerListaUsuarioResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class UsuarioRestTest {

	@Autowired
	private LogueoController lc;
	
	@Autowired
	private ListaUsuarioController luc;
	
	@Test
	public void test() throws CustomException {
		obtenerUsuarioPorLogo();
		ObtenerListaUsuarioResponse();
	}
	
	private void obtenerUsuarioPorLogo() throws CustomException {
		ObtenerDatosUsuarioResponse response;
		response = lc.obtenerUsuarioPorLogo("WCAHUAYA");
	}
	
	private void ObtenerListaUsuarioResponse() throws CustomException {
		ObtenerListaUsuarioResponse response;
		response = luc.obtenerListaUsuario();
	}
}
