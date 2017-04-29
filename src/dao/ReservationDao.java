package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Reservation;

@Local
public interface ReservationDao extends GenericJpaDao<Reservation> {

	List<Reservation> findAllBy(Long userId);

}
