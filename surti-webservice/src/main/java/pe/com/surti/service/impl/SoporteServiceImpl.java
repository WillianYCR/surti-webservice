package pe.com.surti.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.surti.common.exception.CustomException;
import pe.com.surti.dao.ParametroDao;
import pe.com.surti.entity.Parametro;
import pe.com.surti.service.SoporteService;

@Service
public class SoporteServiceImpl implements SoporteService {

	private final static Logger log = Logger.getLogger(SoporteServiceImpl.class
			.getName());

	@Autowired
	private ParametroDao parametoDao;

	@Override
	public List<Parametro> listByEstado(String estado) throws CustomException {
		List<Parametro> listaParametro = parametoDao.listByEstado(estado);
		log.info(listaParametro);
		return listaParametro;
	}

}
