package pe.com.surti.dao.postgres;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public class AbstractConnection {

	private final static Logger log = Logger.getLogger(AbstractConnection.class
			.getName());

	@PersistenceContext
	protected EntityManager entityManager;

	public AbstractConnection() {
		//log.debug("Iniciando proceso con la Base de datos");
	}
	
}