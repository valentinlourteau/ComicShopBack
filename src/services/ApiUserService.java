package services;

import javax.ejb.Local;

import entities.ApiUser;

@Local
public interface ApiUserService { 
	
	public ApiUser findBy(Long id);
	
	public ApiUser findBy(String username, String pwd);

	public String hashPassword(String pwd);

}
