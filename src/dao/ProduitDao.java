package dao;

import java.io.Serializable;
import java.util.List;

import entities.Produit;

public interface ProduitDao extends GenericDao<Produit, Serializable> {

	List<Produit> findMinimalProductsByLibelle(String libelle);

}
