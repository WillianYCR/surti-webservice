package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.SesionDao;
import pe.com.surti.entity.Sesion;

@Transactional
@Repository
public class PostgresSesionDao extends BaseDatoCrudPersistence implements
		SesionDao {

	private static final Logger logPostgres = Logger
			.getLogger(PostgresSesionDao.class.getName());

	@Override
	public Sesion insertarSesion(Sesion sesion) throws CustomException {
		Sesion obj = new Sesion();
		obj = create(sesion);
		logPostgres.debug("SATISFACTORIO: " + obj);
		return obj;
	}

	@Override
	public Sesion modificarSesion(Sesion sesion) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sesion> obtenerListaSesion() throws CustomException {
		CriteriaQuery<Sesion> cq;
		Root<Sesion> root;
		List<Sesion> lista;

		builder = getEm().getCriteriaBuilder();
		cq = builder.createQuery(Sesion.class);
		root = cq.from(Sesion.class);
		cq.select(root);
		lista = getEm().createQuery(cq).getResultList();

		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

	@Override
	public Sesion obtenerSesionPorIdUsuario(String idUsuario)
			throws CustomException {
		List<Object[]> results;

		querySesionPorIdUsuario(idUsuario);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	@Override
	public Sesion obtenerSesionPorId(String idSesion) throws CustomException {
		List<Object[]> results;

		querySesionPorId(idSesion);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void querySesionPorIdUsuario(String idUsuario) {
		queryBusqueda("idUsuario", idUsuario);
	}

	private void querySesionPorId(String idSesion) {
		queryBusqueda("idSesion", idSesion);
	}

	private Sesion formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.Sesion.idSesion).append(Attribute.Sql.Coma);
		sql.append(Attribute.Sesion.idUsuario).append(Attribute.Sql.Coma);
		sql.append(Attribute.Sesion.token).append(Attribute.Sql.Coma);
		sql.append(Attribute.Sesion.fechaIngreso).append(Attribute.Sql.Coma);
		sql.append(Attribute.Sesion.fechaFin).append(Attribute.Sql.Coma);
		sql.append(Attribute.Sesion.estadoLogico).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.Sesion.SESION);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.Sesion.S);
		sql.append(Attribute.Sql.ComillaDoble).append(condicion)
				.append(Attribute.Sql.ComillaDoble);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);

		query = sql.toString();
		logPostgres.debug("QUERY GENERADO: " + query);
	}

	private List<Sesion> formatearLista(List<Object[]> results) {
		List<Sesion> lista = new ArrayList<Sesion>(0);
		if (results != null && !results.isEmpty()) {
			Sesion obj = null;
			for (Object[] res : results) {
				obj = new Sesion();
				obj.setIdSesion(Integer.parseInt(res[0].toString()));
				obj.setIdUsuario(Integer.parseInt(res[1].toString()));
				obj.setToken(res[2] == null ? "" : res[2].toString());
				obj.setFechaIngreso(res[3] == null ? null : null);
				obj.setFechaFin(res[4] == null ? null : null);
				obj.setEstadoLogico(res[5] == null ? "" : res[5].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

}
