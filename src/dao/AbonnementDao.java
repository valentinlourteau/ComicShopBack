package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Abonnement;
import entities.AbonnementAud;

@Local
public interface AbonnementDao extends GenericJpaDao<Abonnement> {

	Abonnement findBy(Long userId, Long serieId);

	List<AbonnementAud> findAbonnementHistoricByUserId(Long userId);

	List<AbonnementAud> findAbonnementHistoricBySerieId(Long serieId);

}
