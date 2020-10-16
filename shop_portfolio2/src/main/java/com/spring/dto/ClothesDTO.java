package com.spring.dto;

public class ClothesDTO {
	private String code;
	private String cname;
	private String ctype;
	private int price;
	private int qty;
	private String size;
	private String filename;
	
	public ClothesDTO() {}

	public ClothesDTO(String code, String cname, String ctype, int price, int qty, String size, String filename) {
		super();
		this.code = code;
		this.cname = cname;
		this.ctype = ctype;
		this.price = price;
		this.qty = qty;
		this.size = size;
		this.filename = filename;
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

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "ClothesDTO [code=" + code + ", cname=" + cname + ", ctype=" + ctype + ", price=" + price + ", qty="
				+ qty + ", size=" + size + ", filename=" + filename + "]";
	}

	
	
	
	
	
}
