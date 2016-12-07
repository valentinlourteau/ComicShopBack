package dao;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;

import entities.ProduitCommentaire;

@Stateless
public class ProduitCommentaireDaoImpl extends GenericJpaDaoImpl<ProduitCommentaire> implements ProduitCommentaireDao {

	@Override
	public ProduitCommentaire findById(long id) {
		return queryFactory().selectFrom(PRODUIT_COMMENTAIRE)
			.where(PRODUIT_COMMENTAIRE.id.eq(id)).fetchOne();
	}

	@Override
	public List<ProduitCommentaire> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProduitCommentaire> findByGuideId(Long id) {
		return queryFactory().selectFrom(PRODUIT_COMMENTAIRE)
				.where(PRODUIT_COMMENTAIRE.guide.id.eq(id))
//				.leftJoin(PRODUIT_COMMENTAIRE.produit, PRODUIT).fetchJoin()
				.distinct()
				.fetch();
	}

}
