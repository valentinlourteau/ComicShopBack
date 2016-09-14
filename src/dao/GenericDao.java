package dao;
import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {
	T persist(T t);

	T find(PK id);

	T merge(T t);

	void delete(T t);
}