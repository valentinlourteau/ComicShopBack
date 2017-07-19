package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Reservation;
import misc.enums.StatutReservationEnum;

@Stateless
@LocalBean
public class ReservationDaoImpl extends GenericJpaDaoImpl<Reservation> implements ReservationDao {

	@Override
	public Reservation findById(long id) {
		return queryFactory().selectFrom(RESERVATION).where(RESERVATION.id.eq(id)).fetchOne();
	}

	@Override
	public List<Reservation> findAll() {
		return queryFactory().selectFrom(RESERVATION).fetch();
	}

	@Override
	public List<Reservation> findAllBy(Long userId) {
		return queryFactory().selectFrom(RESERVATION)
				.where(RESERVATION.user.id.eq(userId))
				.leftJoin(RESERVATION.user, USER)
				.leftJoin(RESERVATION.produit, PRODUIT).fetchJoin()
				.leftJoin(PRODUIT.produitImage, PRODUIT_IMAGE).fetchJoin()
				.distinct()
				.fetch();
	}

	@Override
	public List<Reservation> findAllBy(StatutReservationEnum statut) {
		return queryFactory().selectFrom(RESERVATION)
				.where(RESERVATION.statutReservation.eq(statut))
				.leftJoin(RESERVATION.user, USER).fetchJoin()
				.leftJoin(RESERVATION.produit, PRODUIT).fetchJoin()
				.leftJoin(PRODUIT.produitImage, PRODUIT_IMAGE).fetchJoin()
				.distinct()
				.fetch();
	}

}
