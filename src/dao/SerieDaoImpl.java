package dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Abonnement;
import entities.Serie;
import entities.User;

@Stateless
@LocalBean
public class SerieDaoImpl extends GenericJpaDaoImpl<Serie> implements SerieDao {

	@Override
	public Serie findById(long id) {
		return queryFactory().selectFrom(SERIE).where(SERIE.id.eq(id)).fetchOne();
	}

	@Override
	public List<Serie> findAll() {
		return queryFactory().selectFrom(SERIE).fetch();
	}

	@Override
	public long checkDoublon(String titre) {
		return queryFactory().selectFrom(SERIE).where(SERIE.titre.eq(titre)).fetchCount();
	}

	@Override
	public List<Abonnement> findAllUserWhichSuscribedToTheSerie(Long serieId) {
		return queryFactory().selectFrom(ABONNEMENT).join(ABONNEMENT.user, USER).fetchJoin()
				.where(ABONNEMENT.serie.id.eq(serieId)).distinct().fetch();
	}

	@Override
	public List<Abonnement> findAllSerieWhichAreSuscribedByTheUser(Long userId) {
		return queryFactory().selectFrom(ABONNEMENT).join(ABONNEMENT.serie, SERIE).fetchJoin()
				.where(ABONNEMENT.user.id.eq(userId)).distinct().fetch();
	}

}
