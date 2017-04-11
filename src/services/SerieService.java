package services;

import javax.ejb.Local;

import entities.Abonnement;
import entities.Serie;

@Local
public interface SerieService {

	boolean checkDoublon(String titre);

	Serie findById(Long id);

	void persist(Serie serie);

	Abonnement suscribeToASerie(Long userId, Long serieId);

}
