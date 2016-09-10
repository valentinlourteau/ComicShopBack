package dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class DAOImpl<E> implements DAO<E> {
	
	protected Class entityClass;

	@PersistenceContext
	protected EntityManager entityManager;
	
	public DAOImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class) genericSuperclass.getActualTypeArguments()[1];
	}

	public void persist(E entity) { entityManager.persist(entity); }

	public void remove(E entity) { entityManager.remove(entity); }

	public E findById(Long id) { return (E) entityManager.find(entityClass, id); }

}
