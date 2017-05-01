package services;

import java.util.List;

import javax.ejb.Local;

import entities.Produit;
import entities.Stock;

@Local
public interface ProduitService {

	List<Produit> findAllBy(String libelle);

	Produit findProductById(Integer id);

	Stock findStockByEan(String ean);

	
	
}
