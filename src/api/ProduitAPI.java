package api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import entities.Produit;
import services.ProduitService;

@Path("Produit")
public class ProduitAPI {
	
	@Inject
	ProduitService produitService;
	
	@GET
	public Response findMinimalProductByLibelle(
			@QueryParam("libelle") String libelle) {
		List<Produit> produits = produitService.findMinimalProductsByLibelle(libelle);
		if (produits == null || produits.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok(produits).build();
	}

}
