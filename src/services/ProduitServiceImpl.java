package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProduitDao;
import entities.Produit;

@Stateless
public class ProduitServiceImpl implements ProduitService {
	
	@Inject
	ProduitDao produitDao;

	@Override
	public List<Produit> findMinimalProductsByLibelle(String libelle) {
		return produitDao.findMinimalProductsByLibelle(libelle);
	}

}
