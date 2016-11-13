package services;

import java.util.List;

import javax.ejb.Local;

import entities.Guide;
import entities.Theme;

@Local
public interface GuideService {
	
	public Guide findBy(Long id);
	
	public List<Guide> findAll();
	
	public void persist(Guide newGuide);

	public void delete(Guide guide);

	public List<Guide> findAllByTheme(Theme theme);

}
