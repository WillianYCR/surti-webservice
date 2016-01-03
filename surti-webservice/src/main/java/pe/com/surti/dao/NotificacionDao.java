package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Notificacion;

public interface NotificacionDao {

	Notificacion insertarNotificacion(Notificacion notificacion)
			throws CustomException;

	Notificacion modificarNotificacion(Notificacion notificacion)
			throws CustomException;

	List<Notificacion> obtenerListaNotificacion() throws CustomException;

	Notificacion obtenerNotificacionPorId(String idNotificacion)
			throws CustomException;

}
