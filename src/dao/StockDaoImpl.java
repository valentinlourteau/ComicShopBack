package dao;

import java.util.List;

import javax.ejb.Stateless;

import entities.Stock;

@Stateless
public class StockDaoImpl extends GenericJpaDaoImpl<Stock> implements StockDao {

	@Override
	public Stock findByEan(String ean) {
		return queryFactory().selectFrom(STOCK).where(STOCK.ean.eq(ean)).fetchOne();
	}

	@Override
	public Stock findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stock> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
