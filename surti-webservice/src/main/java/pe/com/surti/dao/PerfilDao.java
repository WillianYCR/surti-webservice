package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Perfil;

public interface PerfilDao {

	List<Perfil> obtenerListaPerfil() throws CustomException;

	Perfil obtenerPerfilPorDescripcion(String descripcion)
			throws CustomException;

	Perfil obtenerPerfilPorAbreviacion(String abreviacion)
			throws CustomException;
}
