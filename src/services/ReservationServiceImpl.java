package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ReservationDao;
import entities.Reservation;
import misc.enums.FormatImageEnum;
import misc.enums.StatutReservationEnum;

@Stateless
@LocalBean
public class ReservationServiceImpl implements ReservationService {

	@Inject
	ReservationDao reservationDao;

	@Inject
	ImageService imageService;

	@Override
	public List<Reservation> findAllBy(Long userId) {
		List<Reservation> reservations = reservationDao.findAllBy(userId);
		reservations.forEach(reservation -> {
			if (reservation.getProduit().getProduitImage() != null)
				reservation.getProduit().getProduitImage()
						.setImage(imageService.getImage(reservation.getProduit().getEan(), FormatImageEnum.SMALL));
		});
		return reservations;
	}

	@Override
	public List<Reservation> findAllBy(StatutReservationEnum statut) {
		List<Reservation> reservations = reservationDao.findAllBy(statut);
		return reservations;
	}
	
}
