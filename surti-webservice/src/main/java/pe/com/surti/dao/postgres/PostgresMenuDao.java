package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.MenuDao;
import pe.com.surti.entity.Menu;

@Transactional
@Repository
public class PostgresMenuDao extends BaseDatoCrudPersistence implements MenuDao {

	private static final Logger logPostgres = Logger
			.getLogger(PostgresMenuDao.class.getName());

	@Override
	public List<Menu> obtenerListaMenu() throws CustomException {
		CriteriaQuery<Menu> cq;
		Root<Menu> root;
		List<Menu> lista;

		builder = getEm().getCriteriaBuilder();
		cq = builder.createQuery(Menu.class);
		root = cq.from(Menu.class);
		cq.select(root);
		lista = getEm().createQuery(cq).getResultList();

		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

	@Override
	public Menu obtenerMenuPorId(String idMenu) throws CustomException {
		List<Object[]> results;

		queryMenuPorId(idMenu);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void queryMenuPorId(String idMenu) {
		queryBusqueda("idMenu", idMenu);
	}

	private Menu formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.Menu.idMenu).append(Attribute.Sql.Coma);
		sql.append(Attribute.Menu.idMenuPadre).append(Attribute.Sql.Coma);
		sql.append(Attribute.Menu.descripcion).append(Attribute.Sql.Coma);
		sql.append(Attribute.Menu.nivel).append(Attribute.Sql.Coma);
		sql.append(Attribute.Menu.codigoPagina).append(Attribute.Sql.Coma);
		sql.append(Attribute.Menu.orden).append(Attribute.Sql.Coma);
		sql.append(Attribute.Menu.detalle).append(Attribute.Sql.Coma);
		sql.append(Attribute.Menu.estado).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.Menu.MENU);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.Menu.M);
		sql.append(Attribute.Sql.ComillaDoble).append(condicion);
		sql.append(Attribute.Sql.ComillaDoble);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);
		query = sql.toString();
		logPostgres.debug("QUERY GENERADO: " + query);
	}

	private List<Menu> formatearLista(List<Object[]> results) {
		List<Menu> lista = new ArrayList<Menu>(0);
		if (results != null && !results.isEmpty()) {
			Menu obj = null;
			for (Object[] res : results) {
				obj = new Menu();
				obj.setIdMenu((Integer.parseInt(res[0].toString())));
				obj.setIdMenuPadre(Integer.parseInt(res[0].toString()));
				obj.setDescripcion(res[2] == null ? "" : res[2].toString());
				obj.setNivel((Integer.parseInt(res[3].toString())));
				obj.setCodigoPagina(res[4] == null ? "" : res[4].toString());
				obj.setOrden((Integer.parseInt(res[5].toString())));
				obj.setDetalle(res[6] == null ? "" : res[6].toString());
				obj.setEstado(res[7] == null ? "" : res[7].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

}
