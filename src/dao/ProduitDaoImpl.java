package dao;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.types.Projections;

import entities.Produit;

@Stateless
public class ProduitDaoImpl extends GenericJpaDaoImpl<Produit> implements ProduitDao {

	@Override
	public List<Produit> findMinimalProductsByLibelle(String libelle) {
//		return queryFactory().select(Projections.bean(Produit.class, PRODUIT.id, PRODUIT.titre).as(PRODUIT))
		return queryFactory().selectFrom(PRODUIT)
//				.from(PRODUIT)
				.where(PRODUIT.titre.containsIgnoreCase(libelle)).fetch();
	}

	@Override
	public Produit findBy(Integer id) {
		return queryFactory().selectFrom(PRODUIT).where(PRODUIT.id.eq(id))
				.fetchOne();
	}

	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
