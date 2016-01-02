package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.UsuarioPerfilDao;
import pe.com.surti.entity.UsuarioPerfil;

@Transactional
@Repository
public class PostgresUsuarioPerfilDao extends BaseDatoCrudPersistence implements
		UsuarioPerfilDao {

	private static final Logger logPostgres = Logger.getLogger(PostgresUsuarioPerfilDao.class
			.getName());

	@Override
	public UsuarioPerfil insertarUsuarioPerfil(UsuarioPerfil usuarioPerfil)
			throws CustomException {
		logPostgres.debug("Inicio");
		UsuarioPerfil userPerf = new UsuarioPerfil();
		userPerf = create(usuarioPerfil);
		logPostgres.debug("Satisfactorio: UsuarioPerfil = " + userPerf);
		return userPerf;
	}

	@Override
	public UsuarioPerfil modificarUsuarioPerfil(UsuarioPerfil usuarioPerfil)
			throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioPerfil> obtenerListaUsuarioPerfil()
			throws CustomException {
		logPostgres.debug("Inicio");
		CriteriaQuery<UsuarioPerfil> cq;
		Root<UsuarioPerfil> root;
		List<UsuarioPerfil> lup;

		builder = getEm().getCriteriaBuilder();
		cq = builder.createQuery(UsuarioPerfil.class);
		root = cq.from(UsuarioPerfil.class);
		cq.select(root);
		lup = getEm().createQuery(cq).getResultList();

		logPostgres.debug("Satisfactorio: Cantidad = " + lup.size());
		return lup;
	}

	@Override
	public List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdUsuario(
			String idUsuario) throws CustomException {
		logPostgres.debug("Inicio");
		List<Object[]> results;

		queryUsuarioPerfilPorIdUsuario(idUsuario);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearLista(results);
	}

	@Override
	public List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdPerfil(
			String idPerfil) throws CustomException {
		logPostgres.debug("Inicio");
		List<Object[]> results;

		queryUsuarioPerfilPorIdPerfil(idPerfil);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearLista(results);
	}

	@Override
	public UsuarioPerfil obtenerUsuarioPerfilPorId(String idUsuarioPerfil)
			throws CustomException {
		logPostgres.debug("Inicio");
		List<Object[]> results;

		queryUsuarioPerfilPorId(idUsuarioPerfil);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void queryUsuarioPerfilPorIdUsuario(String idUsuario) {
		queryBusqueda("idUsuario", idUsuario);
	}

	private void queryUsuarioPerfilPorIdPerfil(String idPerfil) {
		queryBusqueda("idPerfil", idPerfil);
	}
	
	private void queryUsuarioPerfilPorId(String idUsuarioPerfil) {
		queryBusqueda("idUsuarioPerfil", idUsuarioPerfil);
	}

	private UsuarioPerfil formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.UsuarioPerfil.idUsuarioPerfil).append(Attribute.Sql.Coma);
		sql.append(Attribute.UsuarioPerfil.idUsuario).append(Attribute.Sql.Coma);
		sql.append(Attribute.UsuarioPerfil.idPerfil).append(Attribute.Sql.Coma);
		sql.append(Attribute.UsuarioPerfil.estado).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.UsuarioPerfil.USUARIO_PERFIL);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.UsuarioPerfil.UP);
		sql.append(Attribute.Sql.ComillaDoble).append(condicion).
		append(Attribute.Sql.ComillaDoble);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);
		query = sql.toString();
		logPostgres.debug(query);
	}

	private List<UsuarioPerfil> formatearLista(List<Object[]> results) {
		List<UsuarioPerfil> lista = new ArrayList<UsuarioPerfil>(0);
		if (results != null && !results.isEmpty()) {
			UsuarioPerfil obj = null;
			for (Object[] res : results) {
				obj = new UsuarioPerfil();
				obj.setIdUsuarioPerfil(Integer.parseInt(res[0].toString()));
				obj.setIdUsuario(Integer.parseInt(res[1].toString()));
				obj.setIdPerfil(Integer.parseInt(res[2].toString()));
				obj.setEstado(res[3] == null ? "" : res[3].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("Cantidad de registros = " + lista.size());
		return lista;
	}

	

}
