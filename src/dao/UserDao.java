package dao;

import java.io.Serializable;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserDao extends GenericDao<User, Serializable>  {
	
	public User findBy(Long ApiUserId);
	
	public User findBy(String username, String pwd);

}
