package services;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GuideDao;
import entities.Guide;
import entities.Theme;

@Stateless
public class GuideServiceImpl implements GuideService {
	
	@Inject
	GuideDao guideDao;

	@Override
	public Guide findBy(Long id) {
		return guideDao.findById(id);
	}

	@Override
	public List<Guide> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(Guide newGuide) {
		guideDao.persist(newGuide);
	}

	@Override
	public void delete(Guide guide) {
		guideDao.remove(guide);
	}

	@Override
	public List<Guide> findAllByTheme(Theme theme) {
		return guideDao.findAllByTheme(theme);
	}

	@Override
	public void merge(Guide guide) {
		guide.setDateModification(Calendar.getInstance().getTime());
		guideDao.merge(guide);
		
	}

	@Override
	public List<Guide> findAllsWithPictureAndTitle() {
		return guideDao.findAllsWithPictureAndTitle();
	}

}
