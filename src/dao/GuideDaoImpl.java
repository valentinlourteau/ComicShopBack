package dao;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import entities.Guide;
import entities.Theme;

@Stateless
public class GuideDaoImpl extends GenericJpaDaoImpl<Guide> implements GuideDao {

	@Override
	public List<Guide> findAll() {
		JPAQuery<?> query = new JPAQuery<>(em);
		return query.select(GUIDE).from(GUIDE).leftJoin(GUIDE.produitsCommentaires, PRODUITS_COMMENTAIRES).fetchJoin()
				.leftJoin(PRODUITS_COMMENTAIRES.guide).fetchJoin().leftJoin(GUIDE.themes, THEME).fetchJoin().fetch();
	}

	@Override
	public List<Guide> findAllByTheme(Theme theme) {
		JPAQuery<?> query = new JPAQuery<>(em);
		return query.select(GUIDE).from(GUIDE).where(GUIDE.themes.contains(theme))
				.leftJoin(GUIDE.produitsCommentaires, PRODUITS_COMMENTAIRES).fetchJoin()
				.leftJoin(PRODUITS_COMMENTAIRES.guide).fetchJoin().leftJoin(GUIDE.themes, THEME).fetchJoin().fetch();
	}

	@Override
	public Guide findById(long id) {
		JPAQuery<?> query = new JPAQuery<>(em);
		return query.select(GUIDE).from(GUIDE).where(GUIDE.id.eq(id))
				.leftJoin(GUIDE.produitsCommentaires, PRODUITS_COMMENTAIRES).fetchJoin().leftJoin(GUIDE.themes, THEME)
				.fetchJoin().leftJoin(PRODUITS_COMMENTAIRES.guide).fetchJoin().fetchOne();
	}

	@Override
	public Guide merge(Guide entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guide> findAllOrderByAttributeAsc(String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guide> findAllOrderByAttributeDesc(String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guide> findAllsWithPictureAndTitle() {
		return queryFactory().select(Projections.bean(
				Guide.class,
				GUIDE.id,
				GUIDE.titre,
				GUIDE.imageCouverture).as(GUIDE))
				.from(GUIDE).fetch();
	}

}
