package dao;

import javax.ejb.Stateless;

import entities.ApiUser;

@Stateless
public class ApiUserDaoImpl extends DAOImpl<ApiUser> implements ApiUserDao<ApiUser> {

}
