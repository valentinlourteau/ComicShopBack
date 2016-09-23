package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import entities.Guide;

@Local
public interface GuideDao extends GenericDao<Guide, Serializable> {
	
	public List<Guide> findAll();

}
