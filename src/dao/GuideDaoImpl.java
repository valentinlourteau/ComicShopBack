package dao;

import javax.ejb.Stateless;

import entities.Guide;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;

@LocalBean
@Stateless
public class GuideDaoImpl extends GenericDaoJpaImpl<Guide, Serializable> implements GuideDao {

	//TODO implementer la méthode
	@Override
	public List<Guide> findAll() {
		return null;
	}

}
