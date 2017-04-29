package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.jpa.impl.JPAQueryFactory;

import misc.QueryDslEntities;

public abstract class GenericJpaDaoImpl<E> implements GenericJpaDao<E>, QueryDslEntities {

	@PersistenceContext
	protected EntityManager em;

	/**
	 * Fabrique de requètes JPA A utiliser pour toute requète JPA QueryDSL
	 * 
	 * @return JPAQueryFactory
	 */
	protected JPAQueryFactory queryFactory() {
		return new JPAQueryFactory(em);
	}

	@Override
	public void persist(E entity) {
		em.persist(entity);
	}

	@Override
	public void flush() {
		em.flush();
	}

	@Override
	public void remove(E entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void refresh(E entity) {
		em.refresh(entity);
	}

	@Override
	public void detach(E entity) {
		em.detach(entity);
	}
	
	@Override
	public E merge(E entity) {
		em.merge(entity);
		return entity;
	}	

}
