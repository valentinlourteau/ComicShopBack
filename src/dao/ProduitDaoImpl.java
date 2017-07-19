package dao;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.types.Projections;

import entities.Produit;

@Stateless
public class ProduitDaoImpl extends GenericJpaDaoImpl<Produit> implements ProduitDao {

	@Override
	public List<Produit> findAllBy(String libelle) {
		return queryFactory().selectFrom(PRODUIT)
				.leftJoin(PRODUIT.produitImage, PRODUIT_IMAGE).fetchJoin()
				.leftJoin(PRODUIT.stock, STOCK).fetchJoin()
				.where(PRODUIT.titre.containsIgnoreCase(libelle))
				.distinct()
				.fetch();
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

	@Override
	public List<Produit> findAllReducedBy(String libelle) {
		return queryFactory()
				.select(Projections.bean(PRODUIT, PRODUIT.id, PRODUIT.ean, PRODUIT.stock, PRODUIT.titre,
						PRODUIT.titreSecondaire))
				.from(PRODUIT).where(PRODUIT.titre.containsIgnoreCase(libelle)).fetch();
	}

}
