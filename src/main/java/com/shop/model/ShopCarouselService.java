package com.shop.model;

import java.io.InputStream;
import java.util.List;

public class ShopCarouselService {

	private ShopCarouselDAO_interface dao;

	public ShopCarouselService() {
		dao = new ShopCarouselJDBCDAO();
	}

	public ShopCarouselVO addShopCarousel(Integer shopCarouselPosition, Integer prodTypeId, InputStream shopCarouselPic, String shopCarouselUrl) {
		ShopCarouselVO shopCarouselVO = new ShopCarouselVO();
		shopCarouselVO.setShopCarouselPosition(shopCarouselPosition);
		shopCarouselVO.setProdTypeId(prodTypeId);
		shopCarouselVO.setShopCarouselPic(shopCarouselPic);
		shopCarouselVO.setShopCarouselUrl(shopCarouselUrl);
		dao.insert(shopCarouselVO);
		return shopCarouselVO;
	}

	// For Struts2 or SpringMVC use
	public void addShopCarousel(ShopCarouselVO ShopCarouselVO) {
		dao.insert(ShopCarouselVO);
	}

	public ShopCarouselVO updateShopCarousel(Integer shopCarouselId, Integer shopCarouselPosition, Integer prodTypeId, InputStream shopCarouselPic, String shopCarouselUrl) {
		ShopCarouselVO shopCarouselVO = new ShopCarouselVO();
		shopCarouselVO.setShopCarouselId(shopCarouselId);
		shopCarouselVO.setShopCarouselPosition(shopCarouselPosition);
		shopCarouselVO.setProdTypeId(prodTypeId);
		shopCarouselVO.setShopCarouselPic(shopCarouselPic);
		shopCarouselVO.setShopCarouselUrl(shopCarouselUrl);
		dao.update(shopCarouselVO);
		return dao.findByPrimaryKey(shopCarouselId);
	}

	// For Struts2 or SpringMVC use
	public void updateShopCarousel(ShopCarouselVO ShopCarouselVO) {
		dao.insert(ShopCarouselVO);
	}

	public void deleteShopCarousel(Integer prodId) {
		dao.delete(prodId);
	}

	public void getOneShopCarousel(Integer prodId) {
		dao.findByPrimaryKey(prodId);
	}

	public List<ShopCarouselVO> getAll() {
		return dao.getAll();
	}

}
