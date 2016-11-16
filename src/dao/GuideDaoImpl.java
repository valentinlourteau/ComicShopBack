package dao;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import entities.Guide;
import entities.Theme;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;

@Stateless
public class GuideDaoImpl extends GenericJpaDaoImpl<Guide, Serializable> implements GuideDao {

	@Override
	public List<Guide> findAll() {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query.select(GUIDE).from(GUIDE)
				.leftJoin(GUIDE.produitsCommentaires, PRODUITS_COMMENTAIRES).fetchJoin()
				.leftJoin(PRODUITS_COMMENTAIRES.guide).fetchJoin()
				.leftJoin(GUIDE.themes, THEME).fetchJoin()
				.fetch();
	}

	@Override
	public List<Guide> findAllByTheme(Theme theme) {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query.select(GUIDE).from(GUIDE).where(GUIDE.themes.contains(theme))
				.leftJoin(GUIDE.produitsCommentaires, PRODUITS_COMMENTAIRES).fetchJoin()
				.leftJoin(PRODUITS_COMMENTAIRES.guide).fetchJoin()
				.leftJoin(GUIDE.themes, THEME).fetchJoin()
				.fetch();
	}
	
	@Override
	public Guide findBy(Long id) {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query.select(GUIDE).from(GUIDE).where(GUIDE.id.eq(id))
				.leftJoin(GUIDE.produitsCommentaires, PRODUITS_COMMENTAIRES).fetchJoin()
				.fetchOne();
	}

}
