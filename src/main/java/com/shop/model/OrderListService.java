package com.shop.model;

import java.util.List;

public class OrderListService {

	private OrderListDAO_interface dao;

	public OrderListService() {
		dao = new OrderListJDBCDAO();
	}

	public OrderListVO addOrderList(Integer prodOptId, Integer prodOptQuantity, Integer orderExtendedListPrice) {
		OrderListVO OrderListVO = new OrderListVO();
		OrderListVO.setProdOptId(prodOptId);
		OrderListVO.setProdOptQuantity(prodOptQuantity);
		OrderListVO.setOrderExtendedListPrice(orderExtendedListPrice);
		dao.insert(OrderListVO);
		return OrderListVO;
	}

	// For Struts2 or SpringMVC use
	public void addOrderList(OrderListVO OrderListVO) {
		dao.insert(OrderListVO);
	}

	public OrderListVO updateOrderList(Integer orderId, Integer prodOptId, Integer prodOptQuantity, Integer orderExtendedListPrice) {
		OrderListVO OrderListVO = new OrderListVO();
		OrderListVO.setOrderId(orderId);
		OrderListVO.setProdOptId(prodOptId);
		OrderListVO.setProdOptQuantity(prodOptQuantity);
		OrderListVO.setOrderExtendedListPrice(orderExtendedListPrice);
		dao.update(OrderListVO);
		return dao.findByPrimaryKey(orderId);
	}

	// For Struts2 or SpringMVC use
	public void updateOrderList(OrderListVO OrderListVO) {
		dao.insert(OrderListVO);
	}

	public void deleteOrderList(Integer prodId) {
		dao.delete(prodId);
	}

	public void getOneOrderList(Integer prodId) {
		dao.findByPrimaryKey(prodId);
	}

	public List<OrderListVO> getAll() {
		return dao.getAll();
	}

}
