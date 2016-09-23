package dao;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import entities.Guide;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;

@Stateless
public class GuideDaoImpl extends GenericDaoJpaImpl<Guide, Serializable> implements GuideDao {

	@Override
	public List<Guide> findAll() {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query
		.select(GUIDE)
		.from(GUIDE)
		.fetch();
	}

}
