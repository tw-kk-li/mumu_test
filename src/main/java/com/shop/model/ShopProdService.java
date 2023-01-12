package com.shop.model;

import java.io.InputStream;
import java.util.List;

public class ShopProdService {

	private ShopProdDAO_interface dao;

	public ShopProdService() {
		dao = new ShopProdJDBCDAO();
	}

	public ShopProdVO addShopProd(Integer prodTypeId, Integer propId, String prodDescription, InputStream prodPic,
			String prodName, Integer prodStatus) {
		ShopProdVO prodShopVO = new ShopProdVO();
		prodShopVO.setProdTypeId(prodTypeId);
		prodShopVO.setPropId(propId);
		prodShopVO.setProdDescription(prodDescription);
		prodShopVO.setProdPic(prodPic);
		prodShopVO.setProdName(prodName);
		prodShopVO.setProdStatus(prodStatus);
		dao.insert(prodShopVO);
		return prodShopVO;
	}

	// For Struts2 or SpringMVC use
	public void addShopProd(ShopProdVO shopProdVO) {
		dao.insert(shopProdVO);
	}

	public ShopProdVO updateShopProd(Integer prodId, Integer prodTypeId, Integer propId, String prodDescription,
			InputStream prodPic, String prodName, Integer prodStatus) {
		ShopProdVO prodShopVO = new ShopProdVO();
		prodShopVO.setProdId(prodId);
		prodShopVO.setProdTypeId(prodTypeId);
		prodShopVO.setPropId(propId);
		prodShopVO.setProdDescription(prodDescription);
		prodShopVO.setProdPic(prodPic);
		prodShopVO.setProdName(prodName);
		prodShopVO.setProdStatus(prodStatus);
		dao.update(prodShopVO);
		return dao.findByPrimaryKey(prodId);
	}

	// For Struts2 or SpringMVC use
	public void updateShopProd(ShopProdVO shopProdVO) {
		dao.insert(shopProdVO);
	}

	public void deleteShopProd(Integer prodId) {
		dao.delete(prodId);
	}

	public void getOneShopProd(Integer prodId) {
		dao.findByPrimaryKey(prodId);
	}

	public List<ShopProdVO> getAll() {
		return dao.getAll();
	}

}
