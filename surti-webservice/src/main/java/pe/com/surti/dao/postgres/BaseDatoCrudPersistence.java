package pe.com.surti.dao.postgres;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.surti.dao.CrudPersistencia;

@Transactional
@Repository("crudPersistencia")
public class BaseDatoCrudPersistence extends AbstractConnection implements
		CrudPersistencia {

	private final static Logger log = Logger
			.getLogger(BaseDatoCrudPersistence.class.getName());

	protected String query;
	protected CriteriaBuilder builder;

	@Override
	public EntityManager getEm() {
		return entityManager;
	}

	@Override
	public <T> T create(T t) {
		log.info("inserting " + t.getClass().getName());
		this.entityManager.persist(t);
		this.entityManager.flush();
		this.entityManager.refresh(t);
		return t;
	}

	@Override
	public <T> T refresh(T t) {
		log.info("refreshing " + t.getClass().getName());
		this.entityManager.refresh(t);
		return t;
	}

	@Override
	public <T> T find(Object id, Class<T> type) {
		log.info("finding " + type.getName() + " by id=" + id.toString());
		T obj = this.entityManager.find(type, id);
		this.entityManager.refresh(obj);
		return obj;
	}

	@Override
	public void delete(Object t) {
		log.info("deleting " + t.getClass().getName());
		this.entityManager.remove(t);
		this.entityManager.flush();
	}

	@Override
	public <T> T update(T t) {
		log.info("updating " + t.getClass().getName());
		this.entityManager.merge(t);
		this.entityManager.flush();
		this.entityManager.refresh(t);
		return t;
	}

	public List<Object> findByQuery(String sqlQuery, int resultLimit) {
		log.info("Buscando por el query :" + sqlQuery);
		return this.createQuery(sqlQuery).setMaxResults(resultLimit)
				.getResultList();
	}

	private Query createQuery(String query) {
		return this.entityManager.createQuery(query);
	}
}
