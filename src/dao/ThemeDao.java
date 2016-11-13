package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import entities.Theme;

@Local
public interface ThemeDao extends GenericDao<Theme, Serializable> {
	
	public List<Theme> findByQuery(String query, Long limit);

	public List<Theme> findAll();

}
