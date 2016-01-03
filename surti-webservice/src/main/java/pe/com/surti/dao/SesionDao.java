package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Sesion;

public interface SesionDao {

	Sesion insertarSesion(Sesion sesion) throws CustomException;

	Sesion modificarSesion(Sesion sesion) throws CustomException;

	List<Sesion> obtenerListaSesion() throws CustomException;

	Sesion obtenerSesionPorIdUsuario(String idUsuario) throws CustomException;

	Sesion obtenerSesionPorId(String idSesion) throws CustomException;

}
