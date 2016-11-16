package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import entities.Guide;
import entities.Theme;

@Local
public interface GuideDao extends GenericJpaDao<Guide, Serializable> {
	
	public List<Guide> findAll();

	public List<Guide> findAllByTheme(Theme theme);
	
	public Guide findBy(Long id);

}
