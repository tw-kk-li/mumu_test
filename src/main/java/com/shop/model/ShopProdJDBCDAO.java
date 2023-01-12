package com.shop.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopProdJDBCDAO implements ShopProdDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/mumu_test01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "02037";

	public static void main(String[] args) throws FileNotFoundException {
		
		File imgFile = new File("C:\\Users\\Tibame_T14\\Pictures\\Starbucks-001.png");
		FileInputStream fis = new FileInputStream(imgFile);
		
		ShopProdJDBCDAO dao = new ShopProdJDBCDAO();
		ShopProdVO insertTest = new ShopProdVO();
		insertTest.setProdId(21);
		insertTest.setProdTypeId(1);
		insertTest.setPropId(1);
		insertTest.setProdDescription("123");
		insertTest.setProdPic(fis);
		insertTest.setProdName("123");
		insertTest.setProdStatus(1);
		dao.insert(insertTest);
		
		

	}

	// ==============

	private static final String INSERT = "INSERT INTO `shop_product` (`PRODUCT_ID`, `PRODUCT_TYPE_ID`, `PROPOSAL_ID`, `PRODUCT_DESCRIPTION`, `PRODUCT_PICTURE`, `PRODUCT_NAME`, `PRODUCT_STATUS`) VALUES ( ? , ? , ? , ? , ? , ? , ? );";

	@Override
	public void insert(ShopProdVO shopProdVO) {
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(INSERT);
			pstmt.setInt(1, shopProdVO.getProdId());
			pstmt.setInt(2, shopProdVO.getProdTypeId());
			pstmt.setInt(3, shopProdVO.getPropId());
			pstmt.setString(4, shopProdVO.getProdDescription());
			pstmt.setBinaryStream(5, shopProdVO.getProdPic());
			pstmt.setString(6, shopProdVO.getProdName());
			pstmt.setInt(7, shopProdVO.getProdStatus());
			pstmt.executeUpdate();
			System.out.println("Insert完成");

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("無法連接至Database" + e.getMessage());
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

	private static final String UPDATE = "UPDATE `shop_product` SET `PRODUCT_TYPE_ID` = ? , `PROPOSAL_ID` = ? , `PRODUCT_DESCRIPTION` = ? , `PRODUCT_PICTURE` = ? , `PRODUCT_NAME` = ? , `PRODUCT_STATUS` = ? WHERE `PRODUCT_ID` = ? ";

	@Override
	public void update(ShopProdVO shopProdVO) {
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(UPDATE);

			pstmt.setInt(1, shopProdVO.getProdTypeId());
			pstmt.setInt(1, shopProdVO.getPropId());
			pstmt.setString(1, shopProdVO.getProdDescription());
			pstmt.setBinaryStream(1, shopProdVO.getProdPic());
			pstmt.setString(1, shopProdVO.getProdName());
			pstmt.setInt(1, shopProdVO.getProdStatus());
			pstmt.setInt(1, shopProdVO.getProdId());
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

	private static final String DELETE = "DELETE FROM `shop_product` WHERE PRODUCT_ID = ?";

	@Override
	public void delete(Integer prodId) {
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(DELETE);
			pstmt.setInt(1, prodId);
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

	private static final String GET_ONE = "SELECT `PRODUCT_ID`, `PRODUCT_TYPE_ID`, `PROPOSAL_ID`, `PRODUCT_DESCRIPTION`, `PRODUCT_PICTURE`, `PRODUCT_NAME`, `PRODUCT_STATUS` FROM `shop_product` WHERE `PRODUCT_ID` = ?";

	@Override
	public ShopProdVO findByPrimaryKey(Integer product_id) {

		ShopProdVO shopProdVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);

			pstmt = DriverManager.getConnection(url, userid, passwd).prepareStatement(GET_ONE);

			pstmt.setInt(1, product_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				shopProdVO = new ShopProdVO();
				shopProdVO.setProdId(rs.getInt("product_id"));
				shopProdVO.setProdTypeId(rs.getInt("product_type_id"));
				shopProdVO.setPropId(rs.getInt("proposal_id"));
				shopProdVO.setProdDescription(rs.getString("product_description"));
				shopProdVO.setProdPic(rs.getBinaryStream("product_picture"));
				shopProdVO.setProdName(rs.getString("product_name"));
				shopProdVO.setProdStatus(rs.getInt("product_status"));
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

		return shopProdVO;
	}

	// ==============

	private static final String GET_ALL = "SELECT `PRODUCT_ID`, `PRODUCT_TYPE_ID`, `PROPOSAL_ID`, `PRODUCT_DESCRIPTION`, `PRODUCT_PICTURE`, `PRODUCT_NAME`, `PRODUCT_STATUS` FROM `SHOP_PRODUCT` ORDER BY `PRODUCT_ID` ";

	@Override
	public List<ShopProdVO> getAll() {

		List<ShopProdVO> list = new ArrayList<ShopProdVO>();
		ShopProdVO shopProdVO = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			rs = DriverManager.getConnection(url, userid, passwd).prepareStatement(GET_ALL).executeQuery();

			while (rs.next()) {
				shopProdVO = new ShopProdVO();
				shopProdVO.setProdId(rs.getInt("product_id"));
				shopProdVO.setProdTypeId(rs.getInt("product_type_id"));
				shopProdVO.setPropId(rs.getInt("proposal_id"));
				shopProdVO.setProdDescription(rs.getString("product_description"));
				shopProdVO.setProdPic(rs.getBinaryStream("product_picture"));
				
//				shopProdVO.setProdPicString(rs.getString("product_picture"));
				
				shopProdVO.setProdName(rs.getString("product_name"));
				shopProdVO.setProdStatus(rs.getInt("product_status"));
				list.add(shopProdVO);
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
