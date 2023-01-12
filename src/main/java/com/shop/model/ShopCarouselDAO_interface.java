package com.shop.model;

import java.util.List;

public interface ShopCarouselDAO_interface{

	public void insert(ShopCarouselVO shopCarouselVO);
//	public void delete(ShopCarouselVO shopCarouselVO);
	public void delete(Integer shopCarouselId);
	public void update(ShopCarouselVO shopCarouselVO);
	public List<ShopCarouselVO> getAll();
	public ShopCarouselVO findByPrimaryKey(Integer SHOP_CAROUSEL_ID);
	
	
}
