package dao;

import java.io.Serializable;
import java.util.List;

import entities.Produit;

public interface ProduitDao extends GenericJpaDao<Produit, Serializable> {

	List<Produit> findMinimalProductsByLibelle(String libelle);

}
