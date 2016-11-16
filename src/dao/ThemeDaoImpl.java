package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import entities.Theme;

@Stateless
public class ThemeDaoImpl extends GenericJpaDaoImpl<Theme, Serializable> implements ThemeDao {

	@Override
	public List<Theme> findByQuery(String query, Long limit) {
		JPAQuery<Theme> jpaQuery = new JPAQuery<>(entityManager);
		return jpaQuery.select(THEME).from(THEME).where(THEME.libelle.containsIgnoreCase(query)).limit(limit).fetch();
	}

	@Override
	public List<Theme> findAll() {
		JPAQuery<Theme> jpaQuery = new JPAQuery<>(entityManager);
		return jpaQuery.select(THEME).from(THEME).fetch();
	}

}
