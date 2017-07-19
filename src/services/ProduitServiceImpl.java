package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ProduitDao;
import dao.StockDao;
import entities.Produit;
import entities.Stock;

@Stateless
public class ProduitServiceImpl implements ProduitService {
	
	@Inject
	ProduitDao produitDao;
	
	@Inject
	StockDao stockDao;
	
	@Inject
	ImageService imageService;

	@Override
	public List<Produit> findAllBy(String libelle) {
		return produitDao.findAllReducedBy(libelle);
	}

	@Override
	public Produit findProductById(Integer id) {
		Produit produit = produitDao.findBy(id);
		produit.setStock(stockDao.findByEan(produit.getEan()));
		return produit;
	}

	@Override
	public Stock findStockByEan(String ean) {
		return stockDao.findByEan(ean);
	}

	@Override
	public List<Produit> findAllWithImagesBy(String libelle) {
		List<Produit> produits = produitDao.findAllBy(libelle);
		produits.forEach(produit -> imageService.attachImageToProduit(produit));
		return produits;
	}

}
