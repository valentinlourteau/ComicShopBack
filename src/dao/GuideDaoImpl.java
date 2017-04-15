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
	public List<Guide> findAllByTheme(Theme theme) {
		return queryFactory().selectFrom(GUIDE).where(GUIDE.themes.contains(theme))
				.leftJoin(GUIDE.themes, THEME).fetchJoin().fetch();
	}

	@Override
	public Guide findById(long id) {
		return queryFactory().selectFrom(GUIDE).where(GUIDE.id.eq(id))
				.fetchOne();
	}

	@Override
	public List<Guide> findAllsWithPictureAndTitle() {
		return queryFactory()
				.select(Projections.bean(GUIDE, GUIDE.id, GUIDE.titre, GUIDE.imageCouverture, GUIDE.resume, GUIDE.bVisible))
				.from(GUIDE).fetch();

	}

}
