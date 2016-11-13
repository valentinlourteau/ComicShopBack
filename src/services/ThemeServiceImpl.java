package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ThemeDao;
import entities.Theme;

@Stateless
public class ThemeServiceImpl implements ThemeService {
	
	@Inject
	ThemeDao themeDao;

	@Override
	public List<Theme> findByQuery(String query, Long limit) {
		return themeDao.findByQuery(query, limit);
	}

	@Override
	public List<Theme> findAll() {
		return themeDao.findAll();
	}

	@Override
	public Theme findById(Long id) {
		return themeDao.find(id);
	}

}
