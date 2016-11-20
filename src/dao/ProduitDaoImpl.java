package dao;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.types.Projections;

import entities.Produit;
import entities.Stock;

@Stateless
public class ProduitDaoImpl extends GenericJpaDaoImpl<Produit> implements ProduitDao {

	@Override
	public List<Produit> findMinimalProductsByLibelle(String libelle) {
		return queryFactory().select(Projections.bean(Produit.class, PRODUIT.id, PRODUIT.titre))
				.where(PRODUIT.titre.containsIgnoreCase(libelle)).fetch();
	}

	@Override
	public Produit findProductById(Integer id) {
		Produit produit = queryFactory().selectFrom(PRODUIT).where(PRODUIT.id.eq(id)).fetchOne();
		return produit;
	}

	@Override
	public Produit findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit merge(Produit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> findAllOrderByAttributeAsc(String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produit> findAllOrderByAttributeDesc(String attributeName) {
		// TODO Auto-generated method stub
		return null;
	}

}
