package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Parametro;

public interface ParametroDao {

	List<Parametro> listByEstado(String estado) throws CustomException;

	Parametro obtenerParametroPorDescripcion(String descripcion)
			throws CustomException;
}
