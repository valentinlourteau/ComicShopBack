package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UserDao;
import entities.User;
import utils.Crypter;

@Stateless
public class UserServiceImpl implements UserService {
	
	@Inject
	UserDao userDao;

	public User findBy(Long id) {
		return userDao.findBy(id);
	}

	@Override
	public User findBy(String username, String pwd) {
		return userDao.findBy(username, pwd);
	}

	@Override
	public String hashPassword(String pwd) {
		return Crypter.withMD5(pwd);
	}
	
}
