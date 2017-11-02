package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Abonnement;
import entities.Serie;
import entities.User;

@Local
public interface SerieDao extends GenericJpaDao<Serie> {

	long checkDoublon(String titre);

	List<Abonnement> findAllUserWhichSuscribedToTheSerie(Long serieId);

	List<Abonnement> findAllSerieWhichAreSuscribedByTheUser(Long userId);

}
