package com.spring.dto;

//����¡ó���� �˻�ó��

public class PageDTO {
	private int curPage = 1; //����������
	private int perPage = 10; //���������� �Խù���
	private int perBlock = 5; //��ȭ���� ��������
	private int totPage; //��ü��������
	private int startNo; //���۹�ȣ
	private int endNo; //����ȣ
	private int startPage; //����������
	private int endPage;   //����ȣ
	private String findKey;  //�˻�Ű
	private String findValue; //�˻���
	public PageDTO() {
		super();
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPage() {
		return perPage;
	}
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public String getFindKey() {
		return findKey;
	}
	public void setFindKey(String findKey) {
		this.findKey = findKey;
	}
	public String getFindValue() {
		return findValue;
	}
	public void setFindValue(String findValue) {
		this.findValue = findValue;
	}
	@Override
	public String toString() {
		return "PageDTO [curPage=" + curPage + ", perPage=" + perPage + ", perBlock=" + perBlock + ", totPage="
				+ totPage + ", startPage=" + startPage + ", endPage=" + endPage + ", startNo=" + startNo + ", endNo="
				+ endNo + ", findKey=" + findKey + ", findValue=" + findValue + "]";
	}
	
	
}
