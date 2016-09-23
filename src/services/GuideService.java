package services;

import java.util.List;

import javax.ejb.Local;

import entities.Guide;

@Local
public interface GuideService {
	
	public Guide findBy(Long id);
	
	public List<Guide> findAll();

}
