package dao;

import javax.ejb.Local;

import entities.Stock;

@Local
public interface StockDao extends GenericJpaDao<Stock> {
	
	Stock findByEan(String ean);

}
