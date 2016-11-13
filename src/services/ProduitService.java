package services;

import java.util.List;

import javax.ejb.Local;

import entities.Produit;

@Local
public interface ProduitService {

	List<Produit> findMinimalProductsByLibelle(String libelle);

	
	
}
