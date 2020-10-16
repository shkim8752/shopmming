package com.spring.dto;

public class ShopMemberDTO {

	private String userid;
	private String passwd;
	private String name;
	private String email;
	private String address;
	private int authority;
	
	public ShopMemberDTO() {}

	public ShopMemberDTO(String userid, String passwd, String name, String email, String address, int authority) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.address = address;
		this.authority = authority;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAuthority() {
		return authority;
	}

	public void setAuthority(int authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "ShopMemberDTO [userid=" + userid + ", passwd=" + passwd + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", authority=" + authority + "]";
	}
	
	
	
	
}
