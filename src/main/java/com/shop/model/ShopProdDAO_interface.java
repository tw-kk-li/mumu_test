package com.shop.model;

import java.util.List;

public interface ShopProdDAO_interface {
	public void insert(ShopProdVO shopProdVO);
	public void update(ShopProdVO shopProdVO);
	public void delete(Integer prodId);
	
	public ShopProdVO findByPrimaryKey(Integer shopProdVO);
	public List<ShopProdVO> getAll();
}
