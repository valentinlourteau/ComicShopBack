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
		return queryFactory().selectFrom(GUIDE).fetch();
	}

	@Override
	public List<Guide> findAllByTheme(Long themeId) {
		return queryFactory()
				.select(Projections.bean(GUIDE, GUIDE.id, GUIDE.titre, GUIDE.imageCouverture, GUIDE.resume,
						GUIDE.bVisible))
				.from(GUIDE).where(THEME.id.eq(themeId)).leftJoin(GUIDE.themes, THEME).distinct().fetch();
	}

	@Override
	public Guide findById(long id) {
		return queryFactory().selectFrom(GUIDE).where(GUIDE.id.eq(id))
				.leftJoin(GUIDE.produitsCommentaires, PRODUIT_COMMENTAIRE).fetchJoin()
				.leftJoin(PRODUIT_COMMENTAIRE.produit, PRODUIT).fetchJoin().leftJoin(PRODUIT.stock, STOCK).fetchJoin()
				.leftJoin(PRODUIT.image, PRODUIT_IMAGE).fetchJoin().fetchOne();
	}

	@Override
	public List<Guide> findAllsWithPictureAndTitle() {
		return queryFactory().select(
				Projections.bean(GUIDE, GUIDE.id, GUIDE.titre, GUIDE.imageCouverture, GUIDE.resume, GUIDE.bVisible))
				.from(GUIDE).fetch();
	}

}
