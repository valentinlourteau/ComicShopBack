package dao;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.types.Projections;

import entities.Guide;
import entities.Theme;

@Stateless
public class GuideDaoImpl extends GenericJpaDaoImpl<Guide> implements GuideDao {

	@Override
	public List<Guide> findAll() {
		return queryFactory().selectFrom(GUIDE)
//				.leftJoin(GUIDE.produitsCommentaires, PRODUIT_COMMENTAIRE).fetchJoin()
//				.leftJoin(PRODUIT_COMMENTAIRE.produit, PRODUIT).fetchJoin()
//				.leftJoin(GUIDE.themes, THEME).fetchJoin()
				.distinct()
				.fetch();
	}

	@Override
	public List<Guide> findAllByTheme(Theme theme) {
		return queryFactory().selectFrom(GUIDE).where(GUIDE.themes.contains(theme))
//				.leftJoin(GUIDE.produitsCommentaires, PRODUIT_COMMENTAIRE).fetchJoin()
//				.leftJoin(PRODUIT_COMMENTAIRE.guide).fetchJoin()
				.leftJoin(GUIDE.themes, THEME).fetchJoin().fetch();
	}

	@Override
	public Guide findById(long id) {
		return queryFactory().selectFrom(GUIDE).where(GUIDE.id.eq(id))
//				.leftJoin(GUIDE.produitsCommentaires, PRODUIT_COMMENTAIRE).fetchJoin()
//				.leftJoin(PRODUIT_COMMENTAIRE.produit, PRODUIT).fetchJoin()
//				.leftJoin(GUIDE.themes, THEME).fetchJoin()
				.fetchOne();
	}

	@Override
	public List<Guide> findAllsWithPictureAndTitle() {
		return queryFactory().select(Projections.fields(
				Guide.class,
				GUIDE.id,
				GUIDE.titre,
				GUIDE.imageCouverture).as(GUIDE))
				.from(GUIDE).fetch();

	}

}
