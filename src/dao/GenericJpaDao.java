package dao;

import java.util.List;

import com.querydsl.jpa.impl.JPAQuery;

public interface GenericJpaDao<E> {


    E findById(long id);


    void persist(E entity);


    void refresh(E entity);


    E merge(E entity);
    
    void detach(E entity);


    void remove(E entity);


    List<E> findAll();


    List<E> findAllOrderByAttributeAsc(String attributeName);


    List<E> findAllOrderByAttributeDesc(String attributeName);


    void flush();
    
    /**
     * Méthode à redéfinir pour fetch joindre tous les @ToOne associés
     * @param query
     */
    public default void addToOneEntityJoin(JPAQuery<?> query){
        
    }


}
