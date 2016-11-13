package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import entities.Produit;
import entities.Theme;

@Stateless
public class ProduitDaoImpl extends GenericDaoJpaImpl<Produit, Serializable> implements ProduitDao {

	@Override
	public List<Produit> findMinimalProductsByLibelle(String libelle) {
//		return queryFactory.selectFrom(PRODUIT).where(PRODUIT.titre.containsIgnoreCase(libelle)).fetch();
	}

}
