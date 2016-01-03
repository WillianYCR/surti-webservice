package pe.com.surti.dao.postgres;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.UsuarioDao;
import pe.com.surti.entity.Usuario;

@Transactional
@Repository
public class PostgresUsuarioDao extends BaseDatoCrudPersistence implements
		UsuarioDao {

	private static final Logger logPostgres = Logger
			.getLogger(PostgresUsuarioDao.class.getName());

	@Override
	public Usuario insertarUsuario(Usuario usuario) throws CustomException {
		Usuario obj = new Usuario();
		obj = create(usuario);
		logPostgres.debug("SATISFACTORIO: " + obj);
		return obj;
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) throws CustomException {
		Usuario obj = new Usuario();
		obj = update(usuario);
		logPostgres.debug("SATISFACTORIO: " + obj);
		return obj;
	}

	@Override
	public List<Usuario> obtenerListaUsuario() throws CustomException {
		CriteriaQuery<Usuario> cq;
		Root<Usuario> root;
		List<Usuario> lista;

		builder = getEm().getCriteriaBuilder();
		cq = builder.createQuery(Usuario.class);
		root = cq.from(Usuario.class);
		cq.select(root);
		lista = getEm().createQuery(cq).getResultList();

		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

	@Override
	public Usuario obtenerUsuarioPorLogo(String logoUsuario)
			throws CustomException {
		List<Object[]> results;

		queryUsuarioPorLogo(logoUsuario);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	@Override
	public Usuario obtenerUsuarioPorDni(String dniUsuario)
			throws CustomException {
		List<Object[]> results;

		queryUsuarioPorDni(dniUsuario);
		results = getEm().createNativeQuery(query).getResultList();
		return formatearEntidad(results);
	}

	private void queryUsuarioPorLogo(String dniUsuario) {
		queryBusqueda("username", dniUsuario);
	}

	private void queryUsuarioPorDni(String dniUsuario) {
		queryBusqueda("dni", dniUsuario);
	}

	private Usuario formatearEntidad(List<Object[]> results) {
		return formatearLista(results).get(0);
	}

	private void queryBusqueda(String condicion, String valor) {
		query = null;
		StringBuilder sql = new StringBuilder();
		sql.append(Attribute.Sql.Select);
		sql.append(Attribute.Usuario.idUsuario).append(Attribute.Sql.Coma);
		sql.append(Attribute.Usuario.nombreCompleto).append(Attribute.Sql.Coma);
		sql.append(Attribute.Usuario.dni).append(Attribute.Sql.Coma);
		sql.append(Attribute.Usuario.email).append(Attribute.Sql.Coma);
		sql.append(Attribute.Usuario.username).append(Attribute.Sql.Coma);
		sql.append(Attribute.Usuario.clave).append(Attribute.Sql.Coma);
		sql.append(Attribute.Usuario.estado).append(Attribute.Sql.Espacio);
		sql.append(Attribute.Sql.From);
		sql.append(Attribute.Usuario.USUARIO);
		sql.append(Attribute.Sql.Where);
		sql.append(Attribute.Usuario.U).append(condicion);
		sql.append(Attribute.Sql.Igual).append(valor);
		sql.append(Attribute.Sql.Comilla);
		query = sql.toString();
		logPostgres.debug("QUERY GENERADO: " + query);
	}

	private List<Usuario> formatearLista(List<Object[]> results) {
		List<Usuario> lista = new ArrayList<Usuario>(0);
		if (results != null && !results.isEmpty()) {
			Usuario obj = null;
			for (Object[] res : results) {
				obj = new Usuario();
				obj.setIdUsuario(Integer.parseInt(res[0].toString()));
				obj.setNombreCompleto(res[1].toString());
				obj.setDni(res[2] == null ? "" : res[2].toString());
				obj.setEmail(res[3] == null ? "" : res[3].toString());
				obj.setUsername(res[4] == null ? "" : res[4].toString());
				obj.setClave(res[5] == null ? "" : res[5].toString());
				obj.setEstado(res[6] == null ? "" : res[6].toString());
				lista.add(obj);
			}
		}
		logPostgres.debug("SATISFACTORIO: Cantidad = " + lista.size());
		return lista;
	}

}
