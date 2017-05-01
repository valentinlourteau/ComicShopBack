package dao;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.types.Projections;

import entities.Produit;

@Stateless
public class ProduitDaoImpl extends GenericJpaDaoImpl<Produit> implements ProduitDao {

	@Override
	public List<Produit> findAllBy(String libelle) {
		return queryFactory()
				.select(Projections.bean(PRODUIT, PRODUIT.id, PRODUIT.ean, PRODUIT.stock, PRODUIT.titre,
						PRODUIT.titreSecondaire))
				.from(PRODUIT).where(PRODUIT.titre.containsIgnoreCase(libelle)).fetch();
	}

	@Override
	public Produit findBy(Integer id) {
		return queryFactory().selectFrom(PRODUIT).where(PRODUIT.id.eq(id)).fetchOne();
	}

	@Override
	public List<Produit> findAll() {
		return queryFactory().selectFrom(PRODUIT).fetch();
	}

	@Override
	public Produit findById(long id) {
		return null;
	}

}
