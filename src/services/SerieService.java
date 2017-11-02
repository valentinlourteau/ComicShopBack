package services;

import java.util.List;

import javax.ejb.Local;

import entities.Abonnement;
import entities.AbonnementAud;
import entities.Serie;

@Local
public interface SerieService {

	boolean checkDoublon(String titre);

	Serie findById(Long id);

	void persist(Serie serie);

	Abonnement suscribeToASerie(Long userId, Long serieId);

	boolean unsuscribe(Long userId, Long serieId);

	List<AbonnementAud> findAbonnementHistoricByUserId(Long userId);
	
	List<AbonnementAud> findAbonnementHistoricBySerieId(Long serieId);

}
