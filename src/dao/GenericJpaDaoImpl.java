package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;

import com.querydsl.core.Query;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import misc.QueryDslEntities;

public class GenericJpaDaoImpl<T, PK extends Serializable> implements GenericJpaDao<T, PK>, QueryDslEntities {
	

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager entityManager;
	
	private JPAQueryFactory queryFactory;

	public GenericJpaDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		this.queryFactory = new JPAQueryFactory(entityManager);
	}
	
	public JPAQueryFactory queryFactory() {
		return this.queryFactory;
	}

	@Override
	public T persist(T t) {
		this.entityManager.persist(t);
		return t;
	}

	@Override
	public T find(PK id) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T merge(T t) {
		return this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

}