package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.NotificacionDao;
import pe.com.surti.entity.Notificacion;

@Transactional
@Repository
public class PostgresNotificacionDao extends BaseDatoCrudPersistence implements
		NotificacionDao {

	private static final Logger logPostgres = Logger
			.getLogger(PostgresNotificacionDao.class.getName());

	@Override
	public Notificacion insertarNotificacion(Notificacion notificacion)
			throws CustomException {
		Notificacion obj = new Notificacion();
		obj = create(notificacion);
		logPostgres.debug("SATISFACTORIO: " + obj);
		return obj;
	}

	@Override
	public Notificacion modificarNotificacion(Notificacion notificacion)
			throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notificacion> obtenerListaNotificacion() throws CustomException {
		CriteriaQuery<Notificacion> cq;
		Root<Notificacion> root;
		List<Notificacion> lista;

		builder = getEm().getCriteriaBuilder();
		cq = builder.createQuery(Notificacion.class);
		root = cq.from(Notificacion.class);
		cq.select(root);
		lista = getEm().createQuery(cq).getResultList();

		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

	@Override
	public Notificacion obtenerNotificacionPorId(String idNotificacion)
			throws CustomException {
		logPostgres.debug("Inicio");
		List<Object[]> results;

		queryNotificacionPorId(idNotificacion);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void queryNotificacionPorId(String idNotificacion) {
		queryBusqueda("idNotificacion", idNotificacion);
	}

	private Notificacion formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.Notificacion.idNotificacion).append(
				Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.remitente).append(Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.destinatario).append(
				Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.asunto).append(Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.fechaEnvio)
				.append(Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.contenido).append(Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.link).append(Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.estadoNotificacion).append(
				Attribute.Sql.Coma);
		sql.append(Attribute.Notificacion.estadoLogico).append(
				Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.Notificacion.NOTIFICACION);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.Notificacion.N);
		sql.append(Attribute.Sql.ComillaDoble).append(condicion)
				.append(Attribute.Sql.ComillaDoble);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);

		query = sql.toString();
		logPostgres.debug("QUERY GENERADO: " + query);
	}

	private List<Notificacion> formatearLista(List<Object[]> results) {
		List<Notificacion> lista = new ArrayList<Notificacion>(0);
		if (results != null && !results.isEmpty()) {
			Notificacion obj = null;
			for (Object[] res : results) {
				obj = new Notificacion();
				obj.setIdNotificacion(Integer.parseInt(res[0].toString()));
				obj.setRemitente(res[1] == null ? "" : res[1].toString());
				obj.setDestinatario(res[2] == null ? "" : res[2].toString());
				obj.setAsunto(res[3] == null ? "" : res[3].toString());
				obj.setFechaEnvio(res[4] == null ? null : null);
				obj.setContenido(res[5] == null ? "" : res[5].toString());
				obj.setLink(res[6] == null ? "" : res[6].toString());
				obj.setEstadoNotificacion(res[7] == null ? "" : res[7]
						.toString());
				obj.setEstadoLogico(res[8] == null ? "" : res[8].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

}
