package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UserDao;
import entities.User;
import utils.Crypter;

@LocalBean
@Stateless
public class UserServiceImpl implements UserService {
	
	@Inject
	UserDao userDao;

	public User findBy(Long id) {
		return userDao.findById(id);
	}

	@Override
	public User findBy(String email, String pwd) {
		return userDao.findBy(email, hashPassword(pwd));
	}

	@Override
	public String hashPassword(String pwd) {
		return Crypter.withMD5(pwd);
	}

	@Override
	public void persist(User user) {
		userDao.persist(user);
	}

	@Override
	public User findBy(String email) {
		return userDao.findBy(email);
	}

	@Override
	public boolean checkMandatoryFieldsAreFilled(User user) {
		if (user == null || user.getEmail() == null || user.getPrenom() == null || user.getNom() == null || user.getPwd() == null)
			return false;
		return true;
	}
	
}
