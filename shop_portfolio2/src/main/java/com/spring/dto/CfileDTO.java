package com.spring.dto;

import java.util.Date;
import java.util.Map;

public class CfileDTO {
	private String code; 
	private int fnum; 
	private String filename;
	private Date regdate; 
	
	
	public CfileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CfileDTO(String code, int fnum, String filename, Date regdate) {
		super();
		this.code = code;
		this.fnum = fnum;
		this.filename = filename;
		this.regdate = regdate;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public int getFnum() {
		return fnum;
	}


	public void setFnum(int fnum) {
		this.fnum = fnum;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "CfileDTO [code=" + code + ", fnum=" + fnum + ", filename=" + filename + ", regdate=" + regdate + "]";
	}
	

	
}
