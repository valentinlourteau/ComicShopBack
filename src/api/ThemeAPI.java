package api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import entities.Theme;
import services.ThemeService;

@Path("Theme")
public class ThemeAPI {
	
	@Inject
	ThemeService themeService;
	
	@Path("findByLibelle")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Theme> findByQuery(
			@QueryParam("libelle") String libelle) {
		return themeService.findByQuery(libelle);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Theme> findAll() {
		return themeService.findAll();
	}

}
