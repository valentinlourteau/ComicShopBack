package dao;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import entities.Abonnement;

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
		return queryFactory().selectFrom(ABONNEMENT).where(ABONNEMENT.user.id.eq(userId).and(ABONNEMENT.serie.id.eq(serieId))).fetchOne();
	}

}
