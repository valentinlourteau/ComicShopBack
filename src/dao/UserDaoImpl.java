package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import entities.User;

@Stateless
public class UserDaoImpl extends GenericJpaDaoImpl<User> implements UserDao {

	@Override
	public User findBy(String email, String pwd) {
		return queryFactory().selectFrom(USER).where(USER.email.eq(email).and(USER.pwd.eq(pwd))).fetchOne();
	}

	@Override
	public User findById(long id) {
		return queryFactory().selectFrom(USER).where(USER.id.eq(id)).fetchOne();
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findBy(String email) {
		return queryFactory().selectFrom(USER).where(USER.email.eq(email)).fetchOne();
	}

}
