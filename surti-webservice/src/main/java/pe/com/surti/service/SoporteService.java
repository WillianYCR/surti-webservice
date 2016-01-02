package pe.com.surti.service;

import java.util.List;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.entity.Parametro;

public interface SoporteService {

	List<Parametro> listByEstado(String estado) throws CustomException;

}
