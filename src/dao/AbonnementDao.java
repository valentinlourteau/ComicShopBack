package dao;

import javax.ejb.Local;

import entities.Abonnement;

@Local
public interface AbonnementDao extends GenericJpaDao<Abonnement> {

	Abonnement findBy(Long userId, Long serieId);

}
