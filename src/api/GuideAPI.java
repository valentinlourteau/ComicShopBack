package api;

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

import entities.Guide;
import entities.Theme;
import services.GuideService;
import services.ThemeService;

@Path("Guide")
public class GuideAPI {

	@Inject
	GuideService guideService;

	@Inject
	ThemeService themeService;

	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createGuide(Guide guide) {
		guideService.persist(guide);
		guide.setImageCouverture(null);
		return Response.ok(guide).build();
	}
	
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response mergeGuide(Guide guide) {
		guideService.merge(guide);
		return Response.ok(guide).build();
	}
	
	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGuide(@QueryParam("id") Long id) {
		Guide guide = guideService.findBy(id);
		if (guide != null) {
			guideService.delete(guide);
			return Response.accepted(guide).build();
		} else
			return Response.noContent().build();
	}
	
	@Path("findAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(guideService.findAll()).build();
	}
	
	@Path("findAllTitlesAndPictures")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllsWithPictureAndTitle() {
		return Response.ok(guideService.findAllsWithPictureAndTitle()).build();
	}
	

	@Path("findById")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBy(@QueryParam("id") Long id) {
		Guide guide = guideService.findBy(id);
		if (guide == null)
			return Response.noContent().build();
		else
			return Response.ok(guide).build();
	}

	@Path("findByTheme")
	@GET
	public Response findByTheme(@QueryParam("id") Long id) {
		if (id == null)
			return Response.noContent().build();
		Theme theme = themeService.findById(id);
		if (theme != null) {
			List<Guide> guides = guideService.findAllByTheme(theme);
			return Response.ok(guides).build();
		}
		return Response.noContent().build();
	}

}
