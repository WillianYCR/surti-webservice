package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.UsuarioPerfil;

public interface UsuarioPerfilDao {

	UsuarioPerfil insertarUsuarioPerfil(UsuarioPerfil usuarioPerfil)
			throws CustomException;

	UsuarioPerfil modificarUsuarioPerfil(UsuarioPerfil usuarioPerfil)
			throws CustomException;

	List<UsuarioPerfil> obtenerListaUsuarioPerfil() throws CustomException;

	List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdUsuario(String idUsuario)
			throws CustomException;

	List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdPerfil(String idPerfil)
			throws CustomException;

	UsuarioPerfil obtenerUsuarioPerfilPorId(String idUsuarioPerfil)
			throws CustomException;

}
