package pe.com.surti.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.MenuDao;
import pe.com.surti.dao.MenuPerfilDao;
import pe.com.surti.dao.NotificacionDao;
import pe.com.surti.dao.OrganizacionDao;
import pe.com.surti.dao.ParametroDao;
import pe.com.surti.dao.PerfilDao;
import pe.com.surti.dao.SesionDao;
import pe.com.surti.dao.UsuarioDao;
import pe.com.surti.dao.UsuarioPerfilDao;
import pe.com.surti.entity.Menu;
import pe.com.surti.entity.MenuPerfil;
import pe.com.surti.entity.Notificacion;
import pe.com.surti.entity.Organizacion;
import pe.com.surti.entity.Parametro;
import pe.com.surti.entity.Perfil;
import pe.com.surti.entity.Sesion;
import pe.com.surti.entity.Usuario;
import pe.com.surti.entity.UsuarioPerfil;
import pe.com.surti.service.ConsultaService;

@Service
public class EntidadConsultaService implements ConsultaService {
	private final static Logger log = Logger
			.getLogger(EntidadConsultaService.class.getName());

	@Autowired
	private PerfilDao perfilDao;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private UsuarioPerfilDao usuarioPerfilDao;

	@Autowired
	private ParametroDao parametroDao;

	@Autowired
	private OrganizacionDao organizacionDao;

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private SesionDao sesionDao;

	@Autowired
	private NotificacionDao notificacionDao;

	@Autowired
	private MenuPerfilDao menuPerfilDao;

	@Override
	public List<Perfil> obtenerListaPerfil() throws CustomException {
		List<Perfil> lista = perfilDao.obtenerListaPerfil();
		log.debug(lista);
		return lista;
	}

	@Override
	public Perfil obtenerPerfilPorDescripcion(String descripcion)
			throws CustomException {
		Perfil objeto = perfilDao.obtenerPerfilPorDescripcion(descripcion);
		log.debug(objeto);
		return objeto;
	}

	@Override
	public Perfil obtenerPerfilPorAbreviacion(String abreviacion)
			throws CustomException {
		Perfil objeto = perfilDao.obtenerPerfilPorAbreviacion(abreviacion);
		log.debug(objeto);
		return objeto;
	}

	@Override
	public List<Parametro> listByEstado(String estado) throws CustomException {
		List<Parametro> lista = parametroDao.listByEstado(estado);
		log.info(lista);
		return lista;
	}

	@Override
	public Parametro obtenerParametroPorDescripcion(String descripcion)
			throws CustomException {
		Parametro objeto = parametroDao
				.obtenerParametroPorDescripcion(descripcion);
		log.debug(objeto);
		return objeto;
	}

	// Procesos para usuario

	@Override
	public Usuario insertarUsuario(Usuario usuario) throws CustomException {
		usuario = usuarioDao.insertarUsuario(usuario);
		log.debug(usuario);
		return usuario;
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) throws CustomException {
		usuario = usuarioDao.modificarUsuario(usuario);
		log.debug(usuario);
		return usuario;
	}

	@Override
	public List<Usuario> obtenerListaUsuario() throws CustomException {
		List<Usuario> lista = usuarioDao.obtenerListaUsuario();
		log.debug(lista);
		return lista;
	}

	@Override
	public Usuario obtenerUsuarioPorLogo(String logoUsuario)
			throws CustomException {
		Usuario objeto = usuarioDao.obtenerUsuarioPorLogo(logoUsuario);
		log.debug(objeto);
		return objeto;
	}

	@Override
	public Usuario obtenerUsuarioPorDni(String dniUsuario)
			throws CustomException {
		Usuario objeto = usuarioDao.obtenerUsuarioPorDni(dniUsuario);
		log.debug(objeto);
		return objeto;
	}

	// Procesos para usuarioPerfil

	@Override
	public UsuarioPerfil insertarUsuarioPerfil(UsuarioPerfil usuarioPerfil)
			throws CustomException {
		usuarioPerfil = usuarioPerfilDao.insertarUsuarioPerfil(usuarioPerfil);
		log.debug(usuarioPerfil);
		return usuarioPerfil;
	}

	@Override
	public UsuarioPerfil modificarUsuario(UsuarioPerfil usuarioPerfil)
			throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioPerfil> obtenerListaUsuarioPerfil()
			throws CustomException {
		List<UsuarioPerfil> lista = usuarioPerfilDao
				.obtenerListaUsuarioPerfil();
		log.debug(lista);
		return lista;
	}

	@Override
	public List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdUsuario(
			String idUsuario) throws CustomException {
		List<UsuarioPerfil> lista = usuarioPerfilDao
				.obtenerListaUsuarioPerfilPorIdUsuario(idUsuario);
		log.debug(lista);
		return lista;
	}

	@Override
	public List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdPerfil(
			String idPerfil) throws CustomException {
		List<UsuarioPerfil> lista = usuarioPerfilDao
				.obtenerListaUsuarioPerfilPorIdPerfil(idPerfil);
		log.debug(lista);
		return lista;
	}

	@Override
	public UsuarioPerfil obtenerUsuarioPerfilPorId(String idUsuarioPerfil)
			throws CustomException {
		UsuarioPerfil objeto = usuarioPerfilDao
				.obtenerUsuarioPerfilPorId(idUsuarioPerfil);
		log.debug(objeto);
		return objeto;
	}

	// Proceso para organizacion

	@Override
	public Organizacion insertarOrganizacion(Organizacion organizacion)
			throws CustomException {
		organizacion = organizacionDao.insertarOrganizacion(organizacion);
		log.debug(organizacion);
		return organizacion;
	}

	@Override
	public Organizacion modificarOrganizacion(Organizacion organizacion)
			throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Organizacion> obtenerListaOrganizacion() throws CustomException {
		List<Organizacion> lista = organizacionDao.obtenerListaOrganizacion();
		log.debug(lista);
		return lista;
	}

	@Override
	public Organizacion obtenerOrganizacionPorId(String idOrganizacion)
			throws CustomException {
		Organizacion objeto = organizacionDao
				.obtenerOrganizacionPorId(idOrganizacion);
		log.debug(objeto);
		return objeto;
	}

	// Proceso para Menu

	@Override
	public List<Menu> obtenerListaMenu() throws CustomException {
		List<Menu> lista = menuDao.obtenerListaMenu();
		log.debug(lista);
		return lista;
	}

	@Override
	public Menu obtenerMenuPorId(String idMenu) throws CustomException {
		Menu objeto = menuDao.obtenerMenuPorId(idMenu);
		log.debug(objeto);
		return objeto;
	}

	// Proceso para Memu Perfil

	@Override
	public List<MenuPerfil> obtenerListaMenuPerfil() throws CustomException {
		List<MenuPerfil> lista = menuPerfilDao.obtenerListaMenuPerfil();
		log.debug(lista);
		return lista;
	}

	@Override
	public MenuPerfil obtenerMenuPerfilPorId(String idMenuPerfil)
			throws CustomException {
		MenuPerfil objeto = menuPerfilDao.obtenerMenuPerfilPorId(idMenuPerfil);
		log.debug(objeto);
		return objeto;
	}

	// Proceso para Sesion

	@Override
	public Sesion insertarSesion(Sesion sesion) throws CustomException {
		sesion = sesionDao.insertarSesion(sesion);
		log.debug(sesion);
		return sesion;
	}

	@Override
	public Sesion modificarSesion(Sesion sesion) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sesion> obtenerListaSesion() throws CustomException {
		List<Sesion> lista = sesionDao.obtenerListaSesion();
		log.debug(lista);
		return lista;
	}

	@Override
	public Sesion obtenerSesionPorIdUsuario(String idUsuario)
			throws CustomException {
		Sesion objeto = sesionDao.obtenerSesionPorIdUsuario(idUsuario);
		log.debug(objeto);
		return objeto;
	}

	@Override
	public Sesion obtenerSesionPorId(String idSesion) throws CustomException {
		Sesion objeto = sesionDao.obtenerSesionPorId(idSesion);
		log.debug(objeto);
		return objeto;
	}

	// Proceso de notificacion

	@Override
	public Notificacion insertarNotificacion(Notificacion notificacion)
			throws CustomException {
		notificacion = notificacionDao.insertarNotificacion(notificacion);
		log.debug(notificacion);
		return notificacion;
	}

	@Override
	public Notificacion modificarNotificacion(Notificacion notificacion)
			throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notificacion> obtenerListaNotificacion() throws CustomException {
		List<Notificacion> lista = notificacionDao.obtenerListaNotificacion();
		log.debug(lista);
		return lista;
	}

	@Override
	public Notificacion obtenerNotificacionPorId(String idNotificacion)
			throws CustomException {
		Notificacion objeto = notificacionDao
				.obtenerNotificacionPorId(idNotificacion);
		log.debug(objeto);
		return objeto;
	}

}
