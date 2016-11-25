package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProduitDao;
import dao.StockDao;
import entities.Produit;

@Stateless
public class ProduitServiceImpl implements ProduitService {
	
	@Inject
	ProduitDao produitDao;
	
	@Inject
	StockDao stockDao;

	@Override
	public List<Produit> findMinimalProductsByLibelle(String libelle) {
		return produitDao.findMinimalProductsByLibelle(libelle);
	}

	@Override
	public Produit findProductById(Integer id) {
		Produit produit = produitDao.findBy(id);
		produit.setStock(stockDao.findByEan(produit.getEan()));
		return produit;
	}

}
