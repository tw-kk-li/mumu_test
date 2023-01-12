package com.shop.model;

import java.util.List;

public interface ProdTypeDAO_interface {
	
	public void insert(ProdTypeVO prodTypeVO);
//	public void delete(ProdTypeVO prodTypeVO);
	public void delete(Integer prodTypeId);
	public void update(ProdTypeVO prodTypeVO);
	public List<ProdTypeVO> getAll();
	public ProdTypeVO findByPrimaryKey(Integer PRODUCT_TYPE_ID);
	
	
	

}
