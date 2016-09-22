package dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import entities.ApiUser;

@Stateless
public class ApiUserDaoImpl extends GenericDaoJpaImpl<ApiUser, Serializable> implements ApiUserDao {

	@Override
	public ApiUser findBy(Long ApiUserId) {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query.select(API_USER).from(API_USER).where(API_USER.id.eq(ApiUserId)).fetchOne();
	}

	@Override
	public ApiUser findBy(String username, String pwd) {
		JPAQuery<?> query = new JPAQuery<>(entityManager);
		return query.select(API_USER).from(API_USER).where(API_USER.username.eq(username).and(API_USER.pwd.eq(pwd)))
				.fetchOne();
	}

}
