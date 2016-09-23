package api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Guide;
import services.GuideService;

@Path("Guide")
public class GuideAPI {

	@Inject
	GuideService guideService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createGuide(Guide guide) {
		guideService.persist(guide);
		return Response.ok(guide).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGuide(Guide guide) {
		guideService.delete(guide);
		return Response.accepted().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(guideService.findAll()).build();
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBy(
			@QueryParam("id") Long id) {
		Guide guide = guideService.findBy(id);
		if (guide == null)
			return Response.noContent().build();
		else
			return Response.ok(guide).build();
	}

}
