package api;

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

import com.google.common.reflect.TypeToken;

import entities.Produit;
import entities.ProduitCommentaire;
import services.GuideService;
import services.ProduitService;
import utils.GsonFactory;

@Path("ProduitCommentaire")
public class ProduitsCommentairesAPI {

	@Inject
	GuideService guideService;

	@Inject
	ProduitService produitService;

	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduitCommentaire(ProduitCommentaire produitCommentaire) {
		guideService.persist(produitCommentaire);
		return Response.ok(produitCommentaire).build();
	}

	@Path("update")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduitCommentaire(ProduitCommentaire produitCommentaire) {
		guideService.merge(produitCommentaire);
		return Response.ok(produitCommentaire).build();
	}

	@Path("delete")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduitCommentaire(ProduitCommentaire produitCommentaire) {
		guideService.delete(produitCommentaire);
		return Response.ok(produitCommentaire).build();

	}

	@Path("findById")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@QueryParam("id") Long id) {
		ProduitCommentaire prodCum = guideService.findProduitCommentaireById(id);
		if (prodCum.getProduit() != null)
			prodCum.getProduit().setStock(produitService.findStockByEan(prodCum.getProduit().getEan()));
		return Response.ok(prodCum).build();
	}

}
