package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserDao extends GenericJpaDao<User> {
	
	public User findBy(String email, String pwd);

	public User findBy(String email);

	public List<User> findAllUsersToRank();

}
