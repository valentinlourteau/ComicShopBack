package dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.types.Projections;

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
		return queryFactory().select(Projections.bean(USER, 
				USER.id, 
				USER.prenom, 
				USER.nom, 
				USER.email, 
				USER.statutUtilisateur)).from(USER)
				.fetch();
	}

	@Override
	public User findBy(String email) {
		return queryFactory().selectFrom(USER).where(USER.email.eq(email)).fetchOne();
	}

	@Override
	public List<User> findAllUsersToRank() {
		return queryFactory().selectFrom(USER)
				.leftJoin(USER.reservations, RESERVATION).fetchJoin()
				.where(RESERVATION.dateRetraitMax.after(new Date())
						.and(RESERVATION.bFinalise.eq(Boolean.FALSE)))
				.fetch();
	}

}
