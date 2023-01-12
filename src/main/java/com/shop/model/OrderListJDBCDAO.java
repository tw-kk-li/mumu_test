package com.shop.model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderListJDBCDAO implements OrderListDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mumu_test01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "02037";

	public static void main(String[] args) {

//		OrderListJDBCDAO dao = new OrderListJDBCDAO();
//
//		// �s�W
//		OrderListVO testInsert = new OrderListVO();
//		testInsert.setOrderId(2);
//		testInsert.setProdOptId(2);
//		testInsert.setProdOptQuantity(1111);
//		testInsert.setOrderExtendedListPrice(1111);
//		dao.insert(testInsert);

		// �R��
//		dao.delete(2);

		// �d�浧
//		OrderListVO testSelect = dao.findByPrimaryKey(2);
//		System.out.print(testSelect.getOrderId() + " ");
//		System.out.print(testSelect.getProdOptId() + " ");
//		System.out.print(testSelect.getProdOptQuantity() + " ");
//		System.out.print(testSelect.getOrderExtendedListPrice() + " ");

		// ������
//		List<OrderListVO> list = dao.getAll();
//		for(OrderListVO element : list) {
//			System.out.print(element.getOrderId() + " ");
//			System.out.print(element.getProdOptId() + " ");
//			System.out.print(element.getProdOptQuantity() + " ");
//			System.out.print(element.getOrderExtendedListPrice() + " ");
//			System.out.println();
//		}

		// �� - �ӿ����ƦX�D��, �ҥHorder_id��product_option_id���n�g��~�|�ͮ�
//		OrderListVO testUpdate = new OrderListVO();
//		testUpdate.setOrderId(2);
//		testUpdate.setProdOptId(3);
//		testUpdate.setProdOptQuantity(1111);
//		testUpdate.setOrderExtendedListPrice(111);
//		dao.update(testUpdate);

	}

	// ==============

	private static final String INSERT = "INSERT INTO `order_list` (`ORDER_ID`, `PRODUCT_OPTION_ID`, `PRODUCT_OPTION_QUANTITY`, `ORDER_EXTENDED_LIST_PRICE`) VALUES ( ? , ? , ? , ? )";

	@Override
	public void insert(OrderListVO orderListVO) {
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(INSERT);
			pstmt.setInt(1, orderListVO.getOrderId());
			pstmt.setInt(2, orderListVO.getProdOptId());
			pstmt.setInt(3, orderListVO.getProdOptQuantity());
			pstmt.setInt(4, orderListVO.getOrderExtendedListPrice());
			pstmt.executeUpdate();
			System.out.println("更新完成");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("無法連線至Database, 請檢查連線設定 " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("無法執行SQL指令, 請檢察SQL語法 " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	// ==============

	private static final String DELETE = "DELETE FROM `order_list` WHERE order_id = ? ";

	@Override
	public void delete(Integer orderId) {
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(DELETE);

			pstmt.setInt(1, orderId);
			pstmt.executeUpdate();
			System.out.println("刪除完成");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("無法連線至Database, 請檢查連線設定 " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("無法執行SQL指令, 請檢察SQL語法 " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	// ==============
	private static final String UPDATE = "UPDATE `order_list` SET `PRODUCT_OPTION_QUANTITY` = ? ,`ORDER_EXTENDED_LIST_PRICE` = ? WHERE `ORDER_ID` = ? AND `PRODUCT_OPTION_ID` = ? ";

	@Override
	public void update(OrderListVO orderListVO) {
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(UPDATE);

			pstmt.setInt(1, orderListVO.getProdOptQuantity());
			pstmt.setInt(2, orderListVO.getOrderExtendedListPrice());
			pstmt.setInt(3, orderListVO.getOrderId());
			pstmt.setInt(4, orderListVO.getProdOptId());
			pstmt.executeUpdate();
			System.out.println("更新完成");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("無法連線至Database, 請檢查連線設定 " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("無法執行SQL指令, 請檢察SQL語法 " + e.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	// ==============

	private static final String GET_ONE = "SELECT `ORDER_ID`, `PRODUCT_OPTION_ID`, `PRODUCT_OPTION_QUANTITY`, `ORDER_EXTENDED_LIST_PRICE` FROM `order_list` WHERE order_id = ? ";

	@Override
	public OrderListVO findByPrimaryKey(Integer order_id) {
		OrderListVO orderListVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(GET_ONE);
			pstmt.setInt(1, order_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setOrderId(rs.getInt("order_id"));
				orderListVO.setProdOptId(rs.getInt("product_option_id"));
				orderListVO.setProdOptQuantity(rs.getInt("product_option_quantity"));
				orderListVO.setOrderExtendedListPrice(rs.getInt("order_extended_list_price"));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("無法連線至Database, 請檢查連線設定 " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("無法執行SQL指令, 請檢察SQL語法 " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}

		return orderListVO;
	}

	// ==============

	private static final String GET_ALL = "SELECT `order_list`.`ORDER_ID`, `order_list`.`PRODUCT_OPTION_ID`, `order_list`.`PRODUCT_OPTION_QUANTITY`, `order_list`.`ORDER_EXTENDED_LIST_PRICE` FROM `order_list` order by `order_id`";

	@Override
	public List<OrderListVO> getAll() {
		List<OrderListVO> list = new ArrayList<OrderListVO>();
		OrderListVO orderListVO = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			rs = DriverManager.getConnection(url, userid, passwd).prepareStatement(GET_ALL).executeQuery();

			while (rs.next()) {
				orderListVO = new OrderListVO();
				orderListVO.setOrderId(rs.getInt("order_id"));
				orderListVO.setProdOptId(rs.getInt("product_option_id"));
				orderListVO.setProdOptQuantity(rs.getInt("product_option_quantity"));
				orderListVO.setOrderExtendedListPrice(rs.getInt("order_extended_list_price"));
				list.add(orderListVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("無法連線至Database, 請檢查連線設定 " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("無法執行SQL指令, 請檢察SQL語法 " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return list;
	}

}
