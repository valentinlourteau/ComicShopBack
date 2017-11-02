package api;

import javax.inject.Inject;
import javax.jdo.annotations.Query;
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

import dao.SerieDao;
import entities.Abonnement;
import entities.Serie;
import services.SerieService;
import services.UserService;

@Path(value = "Serie")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class SerieAPI extends ParentAPI {

	@Inject
	SerieService serieService;
	
	@Inject
	UserService userService;
	
	@Inject
	SerieDao serieDao;

	@POST
	@Path("create")
	public Response create(Serie serie) {
		if (!serieService.checkDoublon(serie.getTitre())) {
			serieService.persist(serie);
			return Response.ok().build();
		} else
			return Response.notModified().entity(write(serie)).build();

	}

	@DELETE
	@Path("delete")
	public Response delete(@QueryParam("id") Long id) {
		Serie serie = serieService.findById(id);
		if (serie == null)
			return Response.noContent().build();
		serieDao.remove(serie);
		return Response.ok().build();
	}

	@PUT
	@Path("update")
	public Response update(Serie serie) {
		serieDao.merge(serie);
		return Response.accepted(write(serie)).build();
	}

	@GET
	@Path("suscribe")
	public Response suscribe(@QueryParam("userId")Long userId,@QueryParam("serieId")Long serieId) {
		Abonnement abonnement = serieService.suscribeToASerie(userId, serieId);
		if (abonnement == null)
			return Response.notModified().build();
		return Response.ok().build();
	}

	@GET
	@Path("unsuscribe")
	public Response unsuscribe(@QueryParam("userId")Long userId,@QueryParam("serieId")Long serieId) {
		boolean success = serieService.unsuscribe(userId, serieId);
		if (success)
			return Response.ok().build();
		return Response.notModified().build();
	}
	
	@GET
	@Path("findAbonnementHistoricByUserId")
	public Response findAbonnementHistoricByUserId(@QueryParam("userId") Long userId) {
		return Response.ok(write(serieService.findAbonnementHistoricByUserId(userId))).build();
	}
	
	@GET
	@Path("findAbonnementHistoricBySerieId")
	public Response findAbonnementHistoricBySerieId(@QueryParam("serieId") Long serieId) {
		return Response.ok(write(serieService.findAbonnementHistoricBySerieId(serieId))).build();
	}
	
	@GET
	@Path("findAll")
	public Response findAll() {
		return Response.ok(write(serieDao.findAll())).build();
	}
	
	@GET
	@Path("findAllUserBySerieId")
	public Response findAllUserBySerieId(@QueryParam("serieId") Long serieId) {
		return Response.ok(write(serieDao.findAllUserWhichSuscribedToTheSerie(serieId))).build();
	}
	
	@GET
	@Path("findAllSerieByUserId")
	public Response findAllSerieByUserId(@QueryParam("userId") Long userId) {
		return Response.ok(write(serieDao.findAllSerieWhichAreSuscribedByTheUser(userId))).build();
	}

}
