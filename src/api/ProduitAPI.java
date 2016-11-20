package api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Produit;
import services.ProduitService;

@Path("Produit")
public class ProduitAPI {

	@Inject
	ProduitService produitService;

	@Path("findByLibelle")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findMinimalProductsByLibelle(@QueryParam("libelle") String libelle) {
		List<Produit> produits = produitService.findMinimalProductsByLibelle(libelle);
		if (produits == null || produits.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(produits).build();
	}

	@Path("findById")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findProductById(@QueryParam("id") Integer id) {
		Produit produit = produitService.findProductById(id);
		return Response.ok(produit).build();
	}

}
