package services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AbonnementDao;
import dao.SerieDao;
import entities.Abonnement;
import entities.AbonnementAud;
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
		return serieDao.checkDoublon(titre) == 1L ? true : false;
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
		Abonnement newAbo = abonnementDao.findBy(userId, serieId);
		if (user == null || serie == null)
			return null;
		if (newAbo == null) {
			newAbo = new Abonnement();
			newAbo.setSerie(serie);
			newAbo.setUser(user);
		}
		newAbo.setDateMaj(new Date());
		newAbo.setbEnabled(true);
		if (newAbo.getId() == null)
			abonnementDao.persist(newAbo);
		else
			abonnementDao.merge(newAbo);
		return newAbo;
	}

	@Override
	public boolean unsuscribe(Long userId, Long serieId) {
		Abonnement abonnement = abonnementDao.findBy(userId, serieId);
		if (abonnement != null) {
			abonnement.setDateMaj(new Date());
			abonnement.setbEnabled(false);
			abonnementDao.merge(abonnement);
			return true;
		}
		return false;
	}

	@Override
	public List<AbonnementAud> findAbonnementHistoricByUserId(Long userId) {
		List<AbonnementAud> abos = abonnementDao.findAbonnementHistoricByUserId(userId);
		System.out.println(abos.size());
		return abos;
	}

	@Override
	public List<AbonnementAud> findAbonnementHistoricBySerieId(Long serieId) {
		return abonnementDao.findAbonnementHistoricBySerieId(serieId);
	}

}
