package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Produit;

@Local
public interface ProduitDao extends GenericJpaDao<Produit> {

	List<Produit> findMinimalProductsByLibelle(String libelle);
	
	public Produit findBy(Integer id);

}
