package pe.com.surti.service;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Perfil;
import pe.com.surti.entity.Usuario;

public interface SesionService {

	void validarUsuario(String nombreUsuario, String claveUsuario)
			throws CustomException;

	Usuario obtenerUsuarioPorLogo(String logoUsuario) throws CustomException;

	List<Perfil> obtenerListaPerfil() throws CustomException;

}
