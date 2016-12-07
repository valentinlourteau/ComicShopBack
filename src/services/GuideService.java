package services;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import entities.Guide;
import entities.ProduitCommentaire;
import entities.Theme;

@Local
public interface GuideService {
	
	public Guide findBy(Long id);
	
	public List<Guide> findAll();
	
	public void persist(Guide newGuide);

	public void delete(Guide guide);

	public List<Guide> findAllByTheme(Theme theme);

	public void merge(Guide guide);

	public List<Guide> findAllsWithPictureAndTitle();

	public void persist(ProduitCommentaire produitCommentaire);

	public void merge(ProduitCommentaire produitCommentaire);

	public void delete(ProduitCommentaire produitCommentaire);

	public Set<ProduitCommentaire> findProduitsCommentairesByGuideId(Long id);

	public ProduitCommentaire findProduitCommentaireById(Long id);

}
