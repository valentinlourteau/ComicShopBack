package services;

import javax.ejb.Local;

import entities.ApiUser;

@Local
public interface ApiUserService { 
	
	public ApiUser findBy(Long id);

}
