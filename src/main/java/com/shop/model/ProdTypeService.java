package com.shop.model;

import java.util.List;

public class ProdTypeService {

	private ProdTypeDAO_interface dao;

	public ProdTypeService() {
		dao = new ProdTypeJDBCDAO();
	}

	public ProdTypeVO addProdType(String prodTypeName) {
		ProdTypeVO ProdTypeVO = new ProdTypeVO();
		ProdTypeVO.setProdTypeName(prodTypeName);
		dao.insert(ProdTypeVO);
		return ProdTypeVO;
	}

	// For Struts2 or SpringMVC use
	public void addProdType(ProdTypeVO ProdTypeVO) {
		dao.insert(ProdTypeVO);
	}

	public ProdTypeVO updateProdType(Integer prodTypeId, String prodTypeName) {
		ProdTypeVO ProdTypeVO = new ProdTypeVO();
		ProdTypeVO.setProdTypeId(prodTypeId);
		ProdTypeVO.setProdTypeName(prodTypeName);
		dao.update(ProdTypeVO);
		return dao.findByPrimaryKey(prodTypeId);
	}

	// For Struts2 or SpringMVC use
	public void updateProdType(ProdTypeVO ProdTypeVO) {
		dao.insert(ProdTypeVO);
	}

	public void deleteProdType(Integer prodId) {
		dao.delete(prodId);
	}

	public void getOneProdType(Integer prodId) {
		dao.findByPrimaryKey(prodId);
	}

	public List<ProdTypeVO> getAll() {
		return dao.getAll();
	}

}
