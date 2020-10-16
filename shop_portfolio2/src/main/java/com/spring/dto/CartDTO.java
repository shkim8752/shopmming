package com.spring.dto;

public class CartDTO {
	
	private int cartnum;
	private String userid;
	private String code;
	private String cname;
	private int price;
	private String qty;
	private String size;
	private int totprice;
	
	public CartDTO() {
		super();
	}

	public int getCartnum() {
		return cartnum;
	}

	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getTotprice() {
		return totprice;
	}

	public void setTotprice(int totprice) {
		this.totprice = totprice;
	}

	@Override
	public String toString() {
		return "CartDTO [cartnum=" + cartnum + ", userid=" + userid + ", code=" + code + ", cname=" + cname + ", price="
				+ price + ", qty=" + qty + ", size=" + size + ", totprice=" + totprice + "]";
	}

	
}
