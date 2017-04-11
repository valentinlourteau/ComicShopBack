package dao;

import java.util.List;

import javax.ejb.LocalBean;

import javax.ejb.Stateless;

import entities.Abonnement;

@Stateless
@LocalBean
public class AbonnementDaoImpl extends GenericJpaDaoImpl<Abonnement> implements AbonnementDao {

	@Override
	public Abonnement findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Abonnement> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
