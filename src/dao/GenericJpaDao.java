package dao;
import java.io.Serializable;

public interface GenericJpaDao<T, PK extends Serializable> {
	T persist(T t);

	T find(PK id);

	T merge(T t);

	void delete(T t);
	
}