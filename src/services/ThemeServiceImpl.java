package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ThemeDao;
import entities.Theme;

@Stateless
public class ThemeServiceImpl implements ThemeService {
	
	@Inject
	ThemeDao themeDao;

	@Override
	public List<Theme> findByQuery(String query) {
		return themeDao.findByQuery(query);
	}

	@Override
	public List<Theme> findAll() {
		return themeDao.findAll();
	}

	@Override
	public Theme findById(Long id) {
		return themeDao.findById(id);
	}

	@Override
	public void create(List<Theme> themes) {
		themes.forEach(theme -> {
			if (theme.getId() == null) {
				themeDao.persist(theme);
			}
		});
	}

}
