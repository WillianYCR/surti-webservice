package pe.com.surti.dao;

import java.util.List;
import javax.persistence.EntityManager;

public interface CrudPersistencia {

	public <T> T create(T t);

	public <T> T refresh(T t);

	public <T> T find(Object id, Class<T> type);

	public List findByQuery(String sqlQuery, int resultLimit);

	public <T> T update(T t);

	public void delete(Object t);

	public EntityManager getEm();
}