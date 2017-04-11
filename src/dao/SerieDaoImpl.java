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
	public boolean checkDoublon(String titre) {
		return queryFactory().selectFrom(SERIE).where(SERIE.titre.eq(titre)).fetchCount() == 1L ? true : false;
	}

	@Override
	public List<User> findAllUserWhichSuscribedToTheSerie(Long serieId) {
		return queryFactory().selectFrom(ABONNEMENT).where(ABONNEMENT.serie.id.eq(serieId)).distinct().fetch().stream()
				.map(Abonnement::getUser).collect(Collectors.toList());
	}

}
