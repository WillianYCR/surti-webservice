package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.PerfilDao;
import pe.com.surti.entity.Perfil;

@Transactional
@Repository
public class PostgresPerfilDao extends BaseDatoCrudPersistence implements
		PerfilDao {

	private final static Logger logPostgres = Logger
			.getLogger(PostgresPerfilDao.class.getName());

	@Override
	public List<Perfil> obtenerListaPerfil() throws CustomException {
		CriteriaQuery<Perfil> cq;
		Root<Perfil> root;
		List<Perfil> lista;

		builder = entityManager.getCriteriaBuilder();
		cq = builder.createQuery(Perfil.class);
		root = cq.from(Perfil.class);
		cq.select(root);
		lista = getEm().createQuery(cq).getResultList();

		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

	@Override
	public Perfil obtenerPerfilPorDescripcion(String descripcion)
			throws CustomException {
		List<Object[]> results;

		queryPerfilPorDescripcion(descripcion);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	@Override
	public Perfil obtenerPerfilPorAbreviacion(String abreviacion)
			throws CustomException {
		List<Object[]> results;

		queryPerfilPorAbreviacion(abreviacion);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void queryPerfilPorDescripcion(String descripcion) {
		queryBusqueda("descripcion", descripcion);
	}

	private void queryPerfilPorAbreviacion(String abreviacion) {
		queryBusqueda("abreviacion", abreviacion);
	}

	private Perfil formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.Perfil.idPerfil).append(Attribute.Sql.Coma);
		sql.append(Attribute.Perfil.descripcion).append(Attribute.Sql.Coma);
		sql.append(Attribute.Perfil.abreviacion).append(Attribute.Sql.Coma);
		sql.append(Attribute.Perfil.detalle).append(Attribute.Sql.Coma);
		sql.append(Attribute.Perfil.estado).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.Perfil.PERFIL);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.Perfil.P).append(condicion);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);
		query = sql.toString();
		logPostgres.debug("QUERY GENERADO: " + query);
	}

	private List<Perfil> formatearLista(List<Object[]> results) {
		List<Perfil> lista = new ArrayList<Perfil>(0);
		if (results != null && !results.isEmpty()) {
			Perfil perfil = null;
			for (Object[] res : results) {
				perfil = new Perfil();
				perfil.setIdPerfil(Integer.parseInt(res[0].toString()));
				perfil.setDescripcion(res[1].toString());
				perfil.setAbreviacion(res[2] == null ? "" : res[2].toString());
				perfil.setDescripcion(res[3] == null ? "" : res[3].toString());
				perfil.setEstado(res[4] == null ? "" : res[4].toString());
				lista.add(perfil);
			}
		}
		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

}
