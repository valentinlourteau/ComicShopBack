package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Reservation;
import misc.enums.StatutReservationEnum;

@Local
public interface ReservationDao extends GenericJpaDao<Reservation> {

	List<Reservation> findAllBy(Long userId);

	List<Reservation> findAllBy(StatutReservationEnum statut);

}
