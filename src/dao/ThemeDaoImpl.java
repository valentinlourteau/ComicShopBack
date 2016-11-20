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
		JPAQuery<Theme> jpaQuery = new JPAQuery<>(em);
		return jpaQuery.select(THEME).from(THEME).fetch();
	}

	@Override
	public Theme findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Theme merge(Theme entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Theme> findAllOrderByAttributeAsc(String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Theme> findAllOrderByAttributeDesc(String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

}
