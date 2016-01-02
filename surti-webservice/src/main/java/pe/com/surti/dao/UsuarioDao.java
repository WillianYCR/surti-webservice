package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Usuario;

public interface UsuarioDao {
	
	Usuario insertarUsuario(Usuario usuario) throws CustomException;
	
	Usuario modificarUsuario(Usuario usuario) throws CustomException;

	List<Usuario> obtenerListaUsuario() throws CustomException;

	Usuario obtenerUsuarioPorLogo(String logoUsuario) throws CustomException;

	Usuario obtenerUsuarioPorDni(String dniUsuario) throws CustomException;

}
