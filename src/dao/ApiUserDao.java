package dao;

import java.io.Serializable;

import javax.ejb.Local;

import entities.ApiUser;

@Local
public interface ApiUserDao extends GenericDao<ApiUser, Serializable>  {

}
