package dao;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import entities.Theme;

@Stateless
public class ThemeDaoImpl extends GenericJpaDaoImpl<Theme> implements ThemeDao {

	@Override
	public List<Theme> findByQuery(String query) {
		JPAQuery<Theme> jpaQuery = new JPAQuery<>(em);
		return jpaQuery.select(THEME).from(THEME).where(THEME.libelle.containsIgnoreCase(query)).fetch();
	}

	@Override
	public List<Theme> findAll() {
		return queryFactory().selectFrom(THEME).fetch();
	}

	@Override
	public Theme findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
