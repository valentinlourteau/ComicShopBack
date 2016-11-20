package dao;

import java.util.List;

import entities.Produit;

public interface ProduitDao extends GenericJpaDao<Produit> {

	List<Produit> findMinimalProductsByLibelle(String libelle);

	Produit findProductById(Integer id);

}
