package dao;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import entities.ProduitCommentaire;

@Local
public interface ProduitCommentaireDao extends GenericJpaDao<ProduitCommentaire> {

	List<ProduitCommentaire> findByGuideId(Long id);

}
