package dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entities.Reservation;

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
				.distinct()
				.fetch();
	}

}
