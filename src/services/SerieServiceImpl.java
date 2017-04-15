package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AbonnementDao;
import dao.SerieDao;
import entities.Abonnement;
import entities.Serie;
import entities.User;

@Stateless
@LocalBean
public class SerieServiceImpl implements SerieService {
	
	@Inject
	UserService userService;
	
	@Inject
	SerieDao serieDao;
	
	@Inject
	AbonnementDao abonnementDao;

	@Override
	public boolean checkDoublon(String titre) {
		return serieDao.checkDoublon(titre)  == 1L ? true : false;
	}

	@Override
	public Serie findById(Long id) {
		return serieDao.findById(id);
	}

	@Override
	public void persist(Serie serie) {
		serieDao.persist(serie);
	}

	@Override
	public Abonnement suscribeToASerie(Long userId, Long serieId) {
		User user = userService.findBy(userId);
		Serie serie = findById(serieId);
		if (user == null || serie == null || abonnementDao.findBy(userId, serieId) == null ? false : true)
			return null;
		Abonnement newAbo = new Abonnement();
		newAbo.setSerie(serie);
		newAbo.setUser(user);
		abonnementDao.persist(newAbo);
		return newAbo;
	}

	@Override
	public boolean unsuscribe(Long userId, Long serieId) {
		Abonnement abonnement = abonnementDao.findBy(userId, serieId);
		if (abonnement != null) {
			abonnementDao.remove(abonnement);
			return true;
		}
		return false;
	}

}
