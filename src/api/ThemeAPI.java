package api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Theme;
import services.ThemeService;

@Path("Theme")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ThemeAPI extends ParentAPI {

	@Inject
	ThemeService themeService;

	@Path("findByLibelle")
	@GET
	public Response findByQuery(@QueryParam("libelle") String libelle) {
		if (libelle == null)
			return Response.noContent().build();
		return Response.ok(write(themeService.findByQuery(libelle))).build();
	}

	@GET
	@Path("findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		return Response.ok(write(themeService.findAll())).build();
	}

}
