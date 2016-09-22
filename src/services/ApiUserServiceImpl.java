package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ApiUserDao;
import entities.ApiUser;
import utils.Crypter;

@Stateless
public class ApiUserServiceImpl implements ApiUserService {
	
	@Inject
	ApiUserDao apiUserDao;

	public ApiUser findBy(Long id) {
		return apiUserDao.findBy(id);
	}

	@Override
	public ApiUser findBy(String username, String pwd) {
		return apiUserDao.findBy(username, pwd);
	}

	@Override
	public String hashPassword(String pwd) {
		return Crypter.withMD5(pwd);
	}
	
}
