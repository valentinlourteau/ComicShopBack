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

import entities.Produit;
import services.ProduitService;

@Path("Produit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProduitAPI extends ParentAPI {

	@Inject
	ProduitService produitService;

	@Path("findByLibelle")
	@GET
	public Response findMinimalProductsByLibelle(@QueryParam("libelle") String libelle) {
		List<Produit> produits = produitService.findAllBy(libelle);
		if (produits == null || produits.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(write(produits)).build();
	}
	
	@Path("findByLibelleWithImage")
	@GET
	public Response findProduitsWithImages(@QueryParam("libelle") String libelle) {
		List<Produit> produits = produitService.findAllWithImagesBy(libelle);
		if (produits == null || produits.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(write(produits)).build();
	}

	@Path("findById")
	@GET
	public Response findProductById(@QueryParam("id") Integer id) {
		Produit produit = produitService.findProductById(id);
		return Response.ok(write(produit)).build();
	}

}
