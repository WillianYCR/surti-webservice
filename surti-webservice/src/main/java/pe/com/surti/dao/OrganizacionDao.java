package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Organizacion;

public interface OrganizacionDao {
	
	Organizacion insertarOrganizacion(Organizacion organizacion) throws CustomException;
	
	Organizacion modificarOrganizacion(Organizacion organizacion) throws CustomException;
	
	List<Organizacion> obtenerListaOrganizacion() throws CustomException;

	Organizacion obtenerOrganizacionPorId(String idOrganizacion) throws CustomException;
	
}
