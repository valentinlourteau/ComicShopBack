package dao;

public interface DAO<E> {
	
	 void persist(E entity);
     void remove(E entity);
     E findById(Long id);

}
