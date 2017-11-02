package dao;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import entities.Abonnement;
import entities.AbonnementAud;

@Stateless
@LocalBean
public class AbonnementDaoImpl extends GenericJpaDaoImpl<Abonnement> implements AbonnementDao {

	@Override
	public Abonnement findById(long id) {
		return queryFactory().selectFrom(ABONNEMENT).where(ABONNEMENT.id.eq(id)).fetchOne();
	}

	@Override
	public List<Abonnement> findAll() {
		return queryFactory().selectFrom(ABONNEMENT).fetch();
	}

	@Override
	public Abonnement findBy(Long userId, Long serieId) {
		return queryFactory().selectFrom(ABONNEMENT)
				.where(ABONNEMENT.user.id.eq(userId).and(ABONNEMENT.serie.id.eq(serieId))).fetchOne();
	}

	@Override
	public List<AbonnementAud> findAbonnementHistoricByUserId(Long userId) {
		return queryFactory().selectFrom(ABONNEMENT_AUD).leftJoin(ABONNEMENT_AUD.serie).fetchJoin()
				.leftJoin(ABONNEMENT_AUD.user).fetchJoin().where(ABONNEMENT_AUD.user.id.eq(userId)).fetch();
	}

	@Override
	public List<AbonnementAud> findAbonnementHistoricBySerieId(Long serieId) {
		return queryFactory().selectFrom(ABONNEMENT_AUD).leftJoin(ABONNEMENT_AUD.serie).fetchJoin()
				.leftJoin(ABONNEMENT_AUD.user).fetchJoin().where(ABONNEMENT_AUD.serie.id.eq(serieId)).fetch();
	}

}
