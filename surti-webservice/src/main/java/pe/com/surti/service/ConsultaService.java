package pe.com.surti.service;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Menu;
import pe.com.surti.entity.MenuPerfil;
import pe.com.surti.entity.Notificacion;
import pe.com.surti.entity.Organizacion;
import pe.com.surti.entity.Parametro;
import pe.com.surti.entity.Perfil;
import pe.com.surti.entity.Sesion;
import pe.com.surti.entity.Usuario;
import pe.com.surti.entity.UsuarioPerfil;

public interface ConsultaService {

	List<Parametro> listByEstado(String estado) throws CustomException;

	Parametro obtenerParametroPorDescripcion(String descripcion)
			throws CustomException;

	// procesos para Perfil

	List<Perfil> obtenerListaPerfil() throws CustomException;

	Perfil obtenerPerfilPorDescripcion(String descripcion)
			throws CustomException;

	Perfil obtenerPerfilPorAbreviacion(String abreviacion)
			throws CustomException;

	// procesos para usuario

	Usuario insertarUsuario(Usuario usuario) throws CustomException;

	Usuario modificarUsuario(Usuario usuario) throws CustomException;

	List<Usuario> obtenerListaUsuario() throws CustomException;

	Usuario obtenerUsuarioPorLogo(String logoUsuario) throws CustomException;

	Usuario obtenerUsuarioPorDni(String dniUsuario) throws CustomException;

	// procesos para usuarioPerfil

	UsuarioPerfil insertarUsuarioPerfil(UsuarioPerfil usuarioPerfil)
			throws CustomException;

	UsuarioPerfil modificarUsuario(UsuarioPerfil usuarioPerfil)
			throws CustomException;

	List<UsuarioPerfil> obtenerListaUsuarioPerfil() throws CustomException;

	List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdUsuario(String idUsuario)
			throws CustomException;

	List<UsuarioPerfil> obtenerListaUsuarioPerfilPorIdPerfil(String idPerfil)
			throws CustomException;

	UsuarioPerfil obtenerUsuarioPerfilPorId(String idUsuarioPerfil)
			throws CustomException;

	// Proceso para organizacion

	Organizacion insertarOrganizacion(Organizacion organizacion)
			throws CustomException;

	Organizacion modificarOrganizacion(Organizacion organizacion)
			throws CustomException;

	List<Organizacion> obtenerListaOrganizacion() throws CustomException;

	Organizacion obtenerOrganizacionPorId(String idOrganizacion)
			throws CustomException;

	// Proceso para Menu

	List<Menu> obtenerListaMenu() throws CustomException;

	Menu obtenerMenuPorId(String idMenu) throws CustomException;

	// Proceso para MenuPerfil

	List<MenuPerfil> obtenerListaMenuPerfil() throws CustomException;

	MenuPerfil obtenerMenuPerfilPorId(String idMenuPerfil)
			throws CustomException;

	// Proceso para Sesion

	Sesion insertarSesion(Sesion sesion) throws CustomException;

	Sesion modificarSesion(Sesion sesion) throws CustomException;

	List<Sesion> obtenerListaSesion() throws CustomException;

	Sesion obtenerSesionPorIdUsuario(String idUsuario) throws CustomException;

	Sesion obtenerSesionPorId(String idSesion) throws CustomException;

	// Proceso para Notificacion

	Notificacion insertarNotificacion(Notificacion notificacion)
			throws CustomException;

	Notificacion modificarNotificacion(Notificacion notificacion)
			throws CustomException;

	List<Notificacion> obtenerListaNotificacion() throws CustomException;

	Notificacion obtenerNotificacionPorId(String idNotificacion)
			throws CustomException;
}
