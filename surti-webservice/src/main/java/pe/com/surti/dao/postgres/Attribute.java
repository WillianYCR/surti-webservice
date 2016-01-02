package pe.com.surti.dao.postgres;

public interface Attribute {

	interface Sql{
		String Select = "select ";
		String From = "from ";
		String Where = "where ";
		String Coma = ", ";
		String Comilla = "'";
		String ComillaDoble = "\"";
		String Espacio = " ";
		String Igual = " = '";
	}
	
	interface Usuario{
		String USUARIO = "\"USUARIO\" u ";
		String idUsuario = "u.\"idUsuario\"";
		String nombreCompleto = "u.\"nombreCompleto\"";
		String dni = "u.\"dni\"";
		String email = "u.\"email\"";
		String username = "u.\"username\"";
		String clave = "u.\"clave\"";
		String estado = "u.\"estado\"";
		String U = "u.";
	}
	
	interface UsuarioPerfil{
		String USUARIO_PERFIL = "\"USUARIO_PERFIL\" up ";
		String idUsuarioPerfil = "up.\"idUsuarioPerfil\"";
		String idUsuario = "up.\"idUsuario\"";
		String idPerfil = "up.\"idPerfil\"";
		String estado = "up.\"estado\"";
		String UP = "up.";
	}
	
	interface Perfil{
		String PERFIL = "\"PERFIL\" p ";
		String idPerfil = "p.\"idPerfil\"";
		String descripcion = "p.\"descripcion\"";
		String abreviacion = "p.\"abreviacion\"";
		String detalle = "p.\"detalle\"";
		String estado = "p.\"estado\"";
		String P = "p.";
	}
	
	interface Parametro{
		String PARAMETRO = "\"PARAMETRO\" p ";
		String idParametro = "p.\"idParametro\"";
		String descripcion = "p.\"descripcion\"";
		String valor = "p.\"valor\"";
		String valorDefecto = "p.\"valorDefecto\"";
		String detalle = "p.\"detalle\"";
		String P = "p.";
	}
	
	interface Organizacion{
		String ORGANIZACION = "\"ORGANIZACION\" o ";
		String idOrganizacion = "o.\"idOrganizacion\"";
		String descripcion = "o.\"descripcion\"";
		String descripcionSocial = "o.\"descripcionSocial\"";
		String descripcionComercial = "o.\"descripcionComercial\"";
		String ruc = "o.\"ruc\"";
		String direccion = "o.\"direccion\"";
		String telefono = "o.\"telefono\"";
		String email = "o.\"email\"";
		String detalle = "o.\"detalle\"";
		String estado = "o.\"estado\"";
		String O = "o.";
	}
	
	interface Menu{
		String MENU = "\"MENU\" m ";
		String idMenu = "m.\"idMenu\"";
		String idMenuPadre = "m.\"idMenuPadre\"";
		String descripcion = "m.\"descripcion\"";
		String nivel = "m.\"nivel\"";
		String codigoPagina = "m.\"codigoPagina\"";
		String orden = "m.\"orden\"";
		String detalle = "m.\"detalle\"";
		String estado = "m.\"estado\"";
		String M = "m.";
	}
	
	interface MenuPerfil{
		String MENU_PERFIL = "\"MENU_PERFIL\" mp ";
		String idMenuPerfil = "mp.\"idMenuPerfil\"";
		String idMenu = "mp.\"idMenu\"";
		String idPerfil = "mp.\"idPerfil\"";
		String estado = "mp.\"estado\"";
		String MP = "mp.";
	}
}
