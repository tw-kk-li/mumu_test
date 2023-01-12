package com.shop.model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdTypeJDBCDAO implements ProdTypeDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mumu_test01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "02037";

	
	public static void main(String[] args) {
		ProdTypeJDBCDAO dao = new ProdTypeJDBCDAO();
		
		// �s�W
		ProdTypeVO testInsert = new ProdTypeVO();
		testInsert.setProdTypeId(5);
		testInsert.setProdTypeName("測試");
//		dao.insert(testInsert);
		
		// �R��
//		ProdTypeVO testDelete = new ProdTypeVO();
//		testDelete.setProdTypeId(5);
//		dao.delete(testDelete);
//		dao.delete(5);
		
		// 更新
		ProdTypeVO testUpdate = new ProdTypeVO();
		testUpdate.setProdTypeId(5);
		testUpdate.setProdTypeName("測試");
//		dao.update(testUpdate);
		
		// �d�\�浧���
//		ProdTypeVO testSelect1 = dao.findByPrimaryKey(5);
//		System.out.print(testSelect1.getProdTypeId() + " ");
//		System.out.print(testSelect1.getProdTypeName() + " ");
		
		// �d�\�Ҧ����
		List<ProdTypeVO> list = dao.getAll();
//		for(ProdTypeVO element : list) {
//			System.out.print(element.getProdTypeId() + " ");
//			System.out.print(element.getProdTypeName() + " ");
//			System.out.println();
//		}
		
		
		
	}
	
	// ==============

	private static final String INSERT = "INSERT INTO `product_type` (`PRODUCT_TYPE_ID`,`PRODUCT_TYPE_NAME`) VALUES ( ? , ? )";

	@Override
	public void insert(ProdTypeVO prodTypeVO) {

		PreparedStatement pstmt = null;
		try {

			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(INSERT);
			pstmt.setInt(1, prodTypeVO.getProdTypeId());
			pstmt.setString(2, prodTypeVO.getProdTypeName());
			pstmt.executeUpdate();
			System.out.println("Insert完成");

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
	private static final String DELETE = "DELETE FROM `product_type` t WHERE t.PRODUCT_TYPE_ID = ?";

	@Override
	public void delete(Integer prodTypeId) {

		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(DELETE);

//			pstmt.setInt(1, prodTypeVO.getProdTypeId());
			pstmt.setInt(1, prodTypeId);
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
	private static final String UPDATE = "UPDATE `product_type` t SET `PRODUCT_TYPE_NAME` = ? WHERE `PRODUCT_TYPE_ID` = ? ";

	@Override
	public void update(ProdTypeVO prodTypeVO) {
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(UPDATE);

			pstmt.setString(1, prodTypeVO.getProdTypeName());
			pstmt.setInt(2, prodTypeVO.getProdTypeId());
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

	private static final String GET_ALL = "SELECT `PRODUCT_TYPE_ID`, `PRODUCT_TYPE_NAME` FROM `product_type` group by PRODUCT_TYPE_ID";

	@Override
	public List<ProdTypeVO> getAll() {

		List<ProdTypeVO> list = new ArrayList<ProdTypeVO>();
		ProdTypeVO prodTypeVO = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			rs = DriverManager.getConnection(url, userid, passwd).prepareStatement(GET_ALL).executeQuery();

			while (rs.next()) {
				prodTypeVO = new ProdTypeVO();
				prodTypeVO.setProdTypeId(rs.getInt("PRODUCT_TYPE_ID"));
				prodTypeVO.setProdTypeName(rs.getString("PRODUCT_TYPE_NAME"));
				list.add(prodTypeVO);
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

	// ==============

	private static final String GET_ONE = "SELECT `PRODUCT_TYPE_ID`, `PRODUCT_TYPE_NAME`  FROM `product_type` WHERE PRODUCT_TYPE_ID = ?";

	@Override
	public ProdTypeVO findByPrimaryKey(Integer product_type_id) {

		ProdTypeVO prodTypeVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);

			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(GET_ONE);

			pstmt.setInt(1, product_type_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				prodTypeVO = new ProdTypeVO();
				prodTypeVO.setProdTypeId(rs.getInt("product_type_id"));
				prodTypeVO.setProdTypeName(rs.getString("product_type_name"));
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

		return prodTypeVO;
	}

}
