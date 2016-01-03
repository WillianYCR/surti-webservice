package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.OrganizacionDao;
import pe.com.surti.entity.Organizacion;

@Transactional
@Repository
public class PostgresOrganizacionDao extends BaseDatoCrudPersistence implements
		OrganizacionDao {

	private static final Logger logPostgres = Logger
			.getLogger(PostgresOrganizacionDao.class.getName());

	@Override
	public Organizacion insertarOrganizacion(Organizacion organizacion)
			throws CustomException {
		Organizacion obj = new Organizacion();
		obj = create(organizacion);
		logPostgres.debug("SATISFACTORIO: " + obj);
		return obj;
	}

	@Override
	public Organizacion modificarOrganizacion(Organizacion organizacion)
			throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organizacion> obtenerListaOrganizacion() throws CustomException {
		CriteriaQuery<Organizacion> cq;
		Root<Organizacion> root;
		List<Organizacion> lista;

		builder = getEm().getCriteriaBuilder();
		cq = builder.createQuery(Organizacion.class);
		root = cq.from(Organizacion.class);
		cq.select(root);
		lista = getEm().createQuery(cq).getResultList();

		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

	@Override
	public Organizacion obtenerOrganizacionPorId(String idOrganizacion)
			throws CustomException {
		List<Object[]> results;

		queryOrganizacionPorId(idOrganizacion);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void queryOrganizacionPorId(String idOrganizacion) {
		queryBusqueda("idOrganizacion", idOrganizacion);
	}

	private Organizacion formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.Organizacion.idOrganizacion).append(
				Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.descripcion).append(
				Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.descripcionSocial).append(
				Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.descripcionComercial).append(
				Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.ruc).append(Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.direccion).append(Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.telefono).append(Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.email).append(Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.detalle).append(Attribute.Sql.Coma);
		sql.append(Attribute.Organizacion.estado).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.Organizacion.ORGANIZACION);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.Organizacion.O);
		sql.append(Attribute.Sql.ComillaDoble).append(condicion)
				.append(Attribute.Sql.ComillaDoble);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);
		query = sql.toString();
		logPostgres.debug("QUERY GENERADO: " + query);
	}

	private List<Organizacion> formatearLista(List<Object[]> results) {
		List<Organizacion> lista = new ArrayList<Organizacion>(0);
		if (results != null && !results.isEmpty()) {
			Organizacion obj = null;
			for (Object[] res : results) {
				obj = new Organizacion();
				obj.setIdOrganizacion((Integer.parseInt(res[0].toString())));
				obj.setDescripcion(res[1] == null ? "" : res[1].toString());
				obj.setDescripcionSocial(res[2] == null ? "" : res[2]
						.toString());
				obj.setDescripcionComercial(res[3] == null ? "" : res[3]
						.toString());
				obj.setRuc(res[4] == null ? "" : res[4].toString());
				obj.setDireccion(res[5] == null ? "" : res[5].toString());
				obj.setTelefono(res[6] == null ? "" : res[6].toString());
				obj.setEmail(res[7] == null ? "" : res[7].toString());
				obj.setDetalle(res[8] == null ? "" : res[8].toString());
				obj.setEstado(res[9] == null ? "" : res[9].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

}
