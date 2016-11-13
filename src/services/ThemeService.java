package services;

import java.util.List;

import javax.ejb.Local;

import entities.Theme;

@Local
public interface ThemeService {

	List<Theme> findByQuery(String query, Long limit);

	List<Theme> findAll();
	
	Theme findById(Long id);

}