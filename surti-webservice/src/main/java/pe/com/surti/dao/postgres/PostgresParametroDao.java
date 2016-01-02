package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.ParametroDao;
import pe.com.surti.entity.Parametro;

@Transactional
@Repository
public class PostgresParametroDao extends BaseDatoCrudPersistence implements
		ParametroDao {
	private final static Logger logPostgres = Logger
			.getLogger(PostgresParametroDao.class.getName());

	@Override
	public List<Parametro> listByEstado(String estado) throws CustomException {
		logPostgres.debug("Inicio");
		List<Object[]> results;

		queryPerfilPorEstado(estado);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearLista(results);
	}

	@Override
	public Parametro obtenerParametroPorDescripcion(String descripcion)
			throws CustomException {
		logPostgres.debug("Inicio");
		List<Object[]> results;

		queryPerfilPorDescripcion(descripcion);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void queryPerfilPorEstado(String estado) {
		queryBusqueda("estado", estado);
	}

	private void queryPerfilPorDescripcion(String descripcion) {
		queryBusqueda("descripcion", descripcion);
	}

	private Parametro formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.Parametro.idParametro).append(Attribute.Sql.Coma);
		sql.append(Attribute.Parametro.descripcion).append(Attribute.Sql.Coma);
		sql.append(Attribute.Parametro.valor).append(Attribute.Sql.Coma);
		sql.append(Attribute.Parametro.valorDefecto).append(Attribute.Sql.Coma);
		sql.append(Attribute.Parametro.detalle).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.Parametro.PARAMETRO);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.Parametro.P).append(condicion);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);
		query = sql.toString();
		logPostgres.debug(query);
	}

	private List<Parametro> formatearLista(List<Object[]> results) {
		List<Parametro> lista = new ArrayList<Parametro>(0);
		if (results != null && !results.isEmpty()) {
			Parametro obj = null;
			for (Object[] res : results) {
				obj = new Parametro();
				obj.setIdParametro(Integer.parseInt(res[0].toString()));
				obj.setDescripcion(res[1].toString());
				obj.setValor(res[2] == null ? "" : res[2].toString());
				obj.setValorDefecto(res[3] == null ? "" : res[3].toString());
				obj.setDetalle(res[4].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("Cantidad de registros = " + lista.size());
		return lista;
	}

}
