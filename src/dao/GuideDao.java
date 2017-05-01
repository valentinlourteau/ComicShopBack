package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Guide;
import entities.Theme;

@Local
public interface GuideDao extends GenericJpaDao<Guide> {
	
	public List<Guide> findAll();

	public List<Guide> findAllByTheme(Long themeId);

	public List<Guide> findAllsWithPictureAndTitle();
	

}
