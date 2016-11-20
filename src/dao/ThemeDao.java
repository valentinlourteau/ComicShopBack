package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Theme;

@Local
public interface ThemeDao extends GenericJpaDao<Theme> {

	public List<Theme> findByQuery(String query);

	public List<Theme> findAll();

}
