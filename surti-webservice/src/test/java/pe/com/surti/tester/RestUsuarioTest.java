package pe.com.surti.tester;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.controller.ListaUsuarioController;
import pe.com.surti.controller.LogueoController;
import pe.com.surti.controller.request.ObtenerDatosUsuarioRequest;
import pe.com.surti.controller.response.ObtenerDatosUsuarioResponse;
import pe.com.surti.controller.response.ObtenerListaUsuarioResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class RestUsuarioTest {

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
<<<<<<< HEAD:surti-webservice/src/test/java/pe/com/surti/tester/RestUsuarioTest.java
		ObtenerDatosUsuarioRequest oud = new ObtenerDatosUsuarioRequest();
		oud.setUsername("WCAHUAYA");
		response = lc.obtenerUsuarioPorLogo(oud);
=======
		ObtenerDatosUsuarioRequest request = new ObtenerDatosUsuarioRequest();
		request.setUsername("WCAHUAYA");
		response = lc.obtenerUsuarioPorLogo(request);
>>>>>>> 87a16774eff4a277a3124c901b5f41765bc6de7f:surti-webservice/src/test/java/pe/com/surti/tester/UsuarioRestTest.java
	}

	private void ObtenerListaUsuarioResponse() throws CustomException {
		ObtenerListaUsuarioResponse response;
		response = luc.obtenerListaUsuario();
	}
}
