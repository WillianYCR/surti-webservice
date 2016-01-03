package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.MenuPerfil;

public interface MenuPerfilDao {

	List<MenuPerfil> obtenerListaMenuPerfil() throws CustomException;

	MenuPerfil obtenerMenuPerfilPorId(String idMenuPerfil)
			throws CustomException;

}
