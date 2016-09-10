package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.ApiUserDao;
import entities.ApiUser;

@Stateless
public class ApiUserServiceImpl implements ApiUserService {
	
	@Inject
	ApiUserDao<ApiUser> apiUserDao;

	public ApiUser findBy(Long id) {
		return apiUserDao.findById(id);
	}
	
}
