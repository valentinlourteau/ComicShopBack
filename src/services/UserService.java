package services;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserService { 
	
	public User findBy(Long id);
	
	public User findBy(String email, String pwd);

	public String hashPassword(String pwd);

	public void persist(User user);

	public User findBy(String email);

	public boolean checkMandatoryFieldsAreFilled(User user);

}
