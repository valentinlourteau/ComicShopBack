package services;

import java.util.List;

import javax.ejb.Local;

import entities.Reservation;
import misc.enums.StatutReservationEnum;

@Local
public interface ReservationService {
	
	public List<Reservation> findAllBy(Long userId);

	public List<Reservation> findAllBy(StatutReservationEnum statut);

}
