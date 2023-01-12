package com.shop.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Base64;

import org.apache.commons.io.IOUtils;



public class ShopProdVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer prodId;
	private Integer prodTypeId;
	private Integer propId;
	private String prodDescription;
	private InputStream prodPic;
	private String prodName;
	private Integer prodStatus;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public Integer getProdTypeId() {
		return prodTypeId;
	}

	public void setProdTypeId(Integer prodTypeId) {
		this.prodTypeId = prodTypeId;
	}

	public Integer getPropId() {
		return propId;
	}

	public void setPropId(Integer propId) {
		this.propId = propId;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public InputStream getProdPic() {
		return prodPic;
	}

	public void setProdPic(InputStream prodPic) {
		this.prodPic = prodPic;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Integer getProdStatus() {
		return prodStatus;
	}

	public void setProdStatus(Integer prodStatus) {
		this.prodStatus = prodStatus;
	}

	public String getProdPicString() {

		// 拿圖片
	    byte[] bytes = null;

		try {
			bytes = IOUtils.toByteArray(prodPic); // 用org.apache.commons.io.IOUtils的方法去拿InputStream資料
		} catch (IOException e) {
			e.printStackTrace();
		}
	    String encoded = Base64.getEncoder().encodeToString(bytes); // 轉成base64字串
	    System.out.println(encoded);
	    return encoded;  // 當jsp從list集合拿base64字串時, 呼叫此方法並回傳給jsp

	}

}
