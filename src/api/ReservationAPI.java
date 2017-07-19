package api;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.ProduitDao;
import dao.ReservationDao;
import dao.UserDao;
import entities.Reservation;
import entities.User;
import misc.enums.StatutReservationEnum;
import services.ReservationService;
import services.UserService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("Reservation")
public class ReservationAPI extends ParentAPI {

	@Inject
	UserDao userDao;

	@Inject
	ProduitDao produitDao;

	@Inject
	ReservationDao reservationDao;

	@Inject
	UserService userService;
	
	@Inject
	ReservationService reservationService;

	@Path("create")
	@GET
	public Response reserver(@QueryParam("userId") Long userId, @QueryParam("produitId") Integer produitId) {
		Reservation reservation = new Reservation();
		Calendar cal = Calendar.getInstance();
		reservation.setDateReservation(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, 3);
		reservation.setDateRetraitMax(cal.getTime());
		reservation.setStatutReservation(StatutReservationEnum.EN_ATTENTE);
		reservation.setUser(userDao.findById(userId));
		reservation.setProduit(produitDao.findBy(produitId));
		if (reservation.getProduit() != null && reservation.getUser() != null)
			reservationDao.persist(reservation);
		else
			return Response.noContent().build();
		return Response.ok(write(reservation)).build();
	}

	@Path("findAll")
	@GET
	public Response findAll() {
		return Response.ok(write(reservationDao.findAll())).build();
	}

	@Path("updateStatut")
	@PUT
	public Response updateStatut(@QueryParam("reservationId") Long reservationId, @QueryParam("statut") StatutReservationEnum statut) {
		Reservation reservation = reservationDao.findById(reservationId);
		if (reservation == null)
			return Response.noContent().build();
		reservation.setStatutReservation(statut);
		reservationDao.merge(reservation);
		return Response.ok(write(reservation)).build();
	}

	@Path("delete")
	@DELETE
	public Response delete(@QueryParam("reservationId") Long reservationId) {
		Reservation reservation = reservationDao.findById(reservationId);
		if (reservation == null)
			return Response.noContent().build();
		reservationDao.remove(reservation);
		return Response.ok().build();
	}

	@Path("findAllByUser")
	@GET
	public Response findAllByUser(@QueryParam("userId") Long userId) {
		List<Reservation> reservations = reservationService.findAllBy(userId);
		if (reservations.isEmpty())
			return Response.noContent().build();
		return Response.ok(write(reservations)).build();
	}
	
	@Path("findAllByStatut")
	@GET
	public Response findAllByStatut(@QueryParam("statut") StatutReservationEnum statut) {
		List<Reservation> reservations = reservationService.findAllBy(statut);
		if (reservations.isEmpty())
			return Response.noContent().build();
		return Response.ok(write(reservations)).build();
	}

}
