package services;

import java.util.List;

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

	public List<User> findAll();

	public boolean verifyPwd(String oldPassword, String pwd);

	public void merge(User user);

	public List<User> findAllUsersToRank();

}
