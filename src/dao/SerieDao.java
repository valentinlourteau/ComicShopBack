package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Serie;
import entities.User;

@Local
public interface SerieDao extends GenericJpaDao<Serie> {

	long checkDoublon(String titre);

	List<User> findAllUserWhichSuscribedToTheSerie(Long serieId);

	List<Serie> findAllSerieWhichAreSuscribedByTheUser(Long userId);

}
