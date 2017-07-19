package services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GuideDao;
import dao.ProduitCommentaireDao;
import entities.Guide;
import entities.ProduitCommentaire;
import entities.Theme;
import misc.enums.FormatImageEnum;

@Stateless
public class GuideServiceImpl implements GuideService {

	@Inject
	GuideDao guideDao;

	@Inject
	ProduitCommentaireDao produitCommentaireDao;

	@Inject
	ImageService imageService;

	@Override
	public Guide findBy(Long id) {
		Guide guide = guideDao.findById(id);
		guide.getProduitsCommentaires().forEach(prodcom -> {
			if (prodcom.getProduit().getProduitImage() != null)
				prodcom.getProduit().getProduitImage()
						.setImage(imageService.getImage(prodcom.getProduit().getEan(), FormatImageEnum.MEDIUM));
		});
		return guide;
	}

	@Override
	public List<Guide> findAll() {
		return guideDao.findAll();

	}

	@Override
	public void persist(Guide newGuide) {
		newGuide.setDatePublication(new Date());
		guideDao.persist(newGuide);
	}

	@Override
	public void delete(Guide guide) {
		guideDao.remove(guide);
	}

	@Override
	public List<Guide> findAllByTheme(Long themeId) {
		return guideDao.findAllByTheme(themeId);
	}

	@Override
	public void merge(Guide guide) {
		guide.setDateModification(Calendar.getInstance().getTime());
		guideDao.merge(guide);

	}

	@Override
	public List<Guide> findAllsWithPictureAndTitle() {
		return new ArrayList<Guide>(guideDao.findAllsWithPictureAndTitle());
	}

	@Override
	public void persist(ProduitCommentaire produitCommentaire) {
		produitCommentaireDao.persist(produitCommentaire);
	}

	@Override
	public void merge(ProduitCommentaire produitCommentaire) {
		produitCommentaireDao.merge(produitCommentaire);

	}

	@Override
	public void delete(ProduitCommentaire produitCommentaire) {
		produitCommentaireDao.remove(produitCommentaire);
	}

	@Override
	public Set<ProduitCommentaire> findProduitsCommentairesByGuideId(Long id) {
		return new HashSet<>(produitCommentaireDao.findByGuideId(id));
	}

	@Override
	public ProduitCommentaire findProduitCommentaireById(Long id) {
		return produitCommentaireDao.findById(id);
	}

}
