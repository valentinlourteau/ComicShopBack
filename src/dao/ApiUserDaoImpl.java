package dao;

import java.io.Serializable;

import javax.ejb.Stateless;

import entities.ApiUser;

@Stateless
public class ApiUserDaoImpl extends GenericDaoJpaImpl<ApiUser, Serializable> implements ApiUserDao {

}
