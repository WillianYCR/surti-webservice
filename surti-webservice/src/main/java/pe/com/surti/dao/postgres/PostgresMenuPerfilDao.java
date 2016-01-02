package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.MenuPerfilDao;
import pe.com.surti.entity.MenuPerfil;
import pe.com.surti.entity.UsuarioPerfil;

@Transactional
@Repository
public class PostgresMenuPerfilDao extends BaseDatoCrudPersistence implements
		MenuPerfilDao {

	private static final Logger logPostgres = Logger.getLogger(PostgresMenuPerfilDao.class
			.getName());

	@Override
	public List<MenuPerfil> obtenerListaMenuPerfil() throws CustomException {
		logPostgres.debug("Inicio");
		CriteriaQuery<MenuPerfil> cq;
		Root<MenuPerfil> root;
		List<MenuPerfil> lmp;

		builder = getEm().getCriteriaBuilder();
		cq = builder.createQuery(MenuPerfil.class);
		root = cq.from(MenuPerfil.class);
		cq.select(root);
		lmp = getEm().createQuery(cq).getResultList();

		logPostgres.debug("Satisfactorio: Cantidad = " + lmp.size());
		return lmp;
	}


	@Override
	public MenuPerfil obtenerMenuPerfilPorId(String idMenuPerfil)
			throws CustomException {
		logPostgres.debug("Inicio");
		List<Object[]> results;

		queryMenuPerfilPorId(idMenuPerfil);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}
	
	private void queryMenuPerfilPorId(String idMenuPerfil) {
		queryBusqueda("idMenuPerfil", idMenuPerfil);
	}

	private MenuPerfil formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.MenuPerfil.idMenuPerfil).append(Attribute.Sql.Coma);
		sql.append(Attribute.MenuPerfil.idMenu).append(Attribute.Sql.Coma);
		sql.append(Attribute.MenuPerfil.idPerfil).append(Attribute.Sql.Coma);
		sql.append(Attribute.MenuPerfil.estado).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.MenuPerfil.MENU_PERFIL);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.MenuPerfil.MP);
		sql.append(Attribute.Sql.ComillaDoble).append(condicion).
		append(Attribute.Sql.ComillaDoble);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);
		query = sql.toString();
		logPostgres.debug(query);
	}

	private List<MenuPerfil> formatearLista(List<Object[]> results) {
		List<MenuPerfil> lista = new ArrayList<MenuPerfil>(0);
		if (results != null && !results.isEmpty()) {
			MenuPerfil obj = null;
			for (Object[] res : results) {
				obj = new MenuPerfil();
				obj.setIdMenuPerfil(Integer.parseInt(res[0].toString()));
				obj.setIdMenu(Integer.parseInt(res[1].toString()));
				obj.setIdPerfil(Integer.parseInt(res[2].toString()));
				obj.setEstado(res[3] == null ? "" : res[3].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("Cantidad de registros = " + lista.size());
		return lista;
	}


	

	

}
