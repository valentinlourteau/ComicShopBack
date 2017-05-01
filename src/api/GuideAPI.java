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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.spi.HttpResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import entities.Guide;
import entities.Theme;
import services.GuideService;
import services.ProduitService;
import services.ThemeService;

@Path("Guide")
public class GuideAPI extends ParentAPI {

	@Context
	HttpResponse response;

	@Inject
	GuideService guideService;

	@Inject
	ThemeService themeService;

	@Inject
	ProduitService produitService;

	/**
	 * Créer un guide
	 * 
	 * @param guide
	 *            le guide à persister en base
	 * @return le guide crée avec l'image de couverture définie à null pour
	 *         les performances
	 */
	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createGuide(Guide guide) {
		if (guide.getThemes() != null && !guide.getThemes().isEmpty())
			themeService.create(guide.getThemes());
		guideService.persist(guide);
		guide.setImageCouverture(null);
		return Response.ok(write(guide)).build();
	}

	/**
	 * Permet d'update un guide (remplace l'ancien guide par le nouveau) pas
	 * d'appel sans l'id défini sans quoi pas d'update
	 * 
	 * @param guide
	 * @return soit not modified si l'id est null soit le guide updaté
	 */
	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response mergeGuide(Guide guide) {
		if (guide.getId() == null)
			return Response.notModified().build();
		else
			guideService.merge(guide);
		return Response.ok(write(guide)).build();
	}

	/**
	 * Permet de delete un guide, lors de la suppression, les
	 * produitsCommentaires associés sont également supprimés en cascade
	 * 
	 * @param id
	 *            l'id du guide à supprimer
	 * @return
	 */
	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGuide(@QueryParam("id") Long id) {
		Guide guide = guideService.findBy(id);
		if (guide != null) {
			guideService.delete(guide);
			return Response.accepted(write(guide)).build();
		} else
			return Response.noContent().build();
	}

	/**
	 * Permet de récupérer tous les guides en fetchant les lazy join
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@Path("findAll")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		List<Guide> guides = guideService.findAll();
		return Response.ok(write(guides)).build();
	}

	/**
	 * Permet de récupérer une liste de guide en ne récupérant que l'id,
	 * l'image de couverture et le titre
	 * 
	 * @return
	 */
	@Path("findAllReduced")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllsWithPictureAndTitle() {
		return Response.ok(write(guideService.findAllsWithPictureAndTitle())).build();
	}

	/**
	 * Permet de récupérer un guide par son id en fetchant les lazy join
	 * 
	 * @param id
	 * @return
	 */
	@Path("findById")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findBy(@QueryParam("id") Long id) {
		Guide guide = guideService.findBy(id);
		if (guide == null)
			return Response.noContent().build();
		return Response.ok(write(guide)).build();
	}

	/**
	 * permet de r�cup�rer un guide par son th�me
	 * 
	 * @param id
	 * @return
	 */
	@Path("findByTheme")
	@GET
	public Response findByTheme(@QueryParam("id") Long id) {
		if (id == null)
			return Response.noContent().build();
		List<Guide> guides = guideService.findAllByTheme(id);
		if (!guides.isEmpty())
			return Response.ok(write(guides)).build();
		return Response.noContent().build();
	}

}
