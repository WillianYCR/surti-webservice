package pe.com.surti.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.PerfilDao;
import pe.com.surti.dao.UsuarioDao;
import pe.com.surti.entity.Perfil;
import pe.com.surti.entity.Usuario;
import pe.com.surti.service.SesionService;

@Service
public class SesionServiceImpl implements SesionService {

	private final static Logger log = Logger.getLogger(SesionServiceImpl.class
			.getName());

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private PerfilDao perfilDao;

	@Override
	public void validarUsuario(String nombreUsuario, String claveUsuario)
			throws CustomException {
		// TODO Falta implementar la validacion de usuario
	}

	@Override
	public List<Perfil> obtenerListaPerfil() throws CustomException {
		List<Perfil> lista = perfilDao.obtenerListaPerfil();
		log.debug(lista);
		return lista;
	}

	@Override
	public Usuario obtenerUsuarioPorLogo(String logoUsuario)
			throws CustomException {
		Usuario objeto = usuarioDao.obtenerUsuarioPorLogo(logoUsuario);
		log.debug(objeto);
		return objeto;
	}

}
