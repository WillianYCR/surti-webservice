package pe.com.surti.dao;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Menu;

public interface MenuDao {
	
	List<Menu> obtenerListaMenu() throws CustomException;

	Menu obtenerMenuPorId(String idMenu) throws CustomException;
	
}
