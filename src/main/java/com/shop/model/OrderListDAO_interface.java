package com.shop.model;

import java.util.List;

public interface OrderListDAO_interface {
	public void insert(OrderListVO orderListVO);
	public void update(OrderListVO orderListVO);
	public void delete(Integer orderId);

	public OrderListVO findByPrimaryKey(Integer orderListVO);
	public List<OrderListVO> getAll();
}
