package com.spring.dto;

public class SizeDTO {
	private String code;
	private String size;
	private String qty;
	
	public SizeDTO() {}

	public SizeDTO(String code, String size, String qty) {
		super();
		this.code = code;
		this.size = size;
		this.qty = qty;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "SizeDTO [code=" + code + ", size=" + size + ", qty=" + qty + "]";
	}
	
	
	
	
}
