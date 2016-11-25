package dao;

import java.util.List;

public interface GenericJpaDao<E> {

	E findById(long id);

	void persist(E entity);

	void refresh(E entity);

	E merge(E entity);

	void detach(E entity);

	void remove(E entity);

	List<E> findAll();

	void flush();

}
