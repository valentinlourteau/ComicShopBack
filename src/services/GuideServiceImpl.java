package services;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GuideDao;
import dao.ProduitCommentaireDao;
import entities.Guide;
import entities.ProduitCommentaire;
import entities.Theme;

@Stateless
public class GuideServiceImpl implements GuideService {

	@Inject
	GuideDao guideDao;

	@Inject
	ProduitCommentaireDao produitCommentaireDao;

	@Override
	public Guide findBy(Long id) {
		Guide guide = guideDao.findById(id);
		guide.getProduitsCommentaires().forEach(prodcom -> {
			if (prodcom.getProduit().getImage() != null) {
				Path path = Paths.get("/var/www/html/static/img/products/" + prodcom.getProduit().getImage().getProdImageFront());
				try {
					prodcom.getProduit().getImage().setImage(Files.readAllBytes(path));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
	public List<Guide> findAllByTheme(Theme theme) {
		return guideDao.findAllByTheme(theme);
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
