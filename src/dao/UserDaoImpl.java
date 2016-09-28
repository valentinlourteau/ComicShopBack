package dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import entities.User;

@Stateless
public class UserDaoImpl extends GenericDaoJpaImpl<User, Serializable> implements UserDao {

	@Override
	public User findBy(Long ApiUserId) {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query.select(USER).from(USER).where(USER.id.eq(ApiUserId)).fetchOne();
	}

	@Override
	public User findBy(String username, String pwd) {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query.select(USER).from(USER).where(USER.username.eq(username).and(USER.pwd.eq(pwd)))
				.fetchOne();
	}

}
