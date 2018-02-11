package com.develop.sfaw.repository;

public class GoodsAPI {

	private String gdsCd;	// 상품코드
	private String gdsType;	// 상품 대분류
	private String color;	// 색상 ( 코드화 )
	private String size;	// 사이즈 ( 코드화 )
	private String gdsNm;	// 상품명
	private String gdsImg;	// 상품 이미지
	private int price;		// 가격
	private int enabled;	// 사용 가능 여부
	private int quantity;	// 재고 수량
	private String regDt;
	private String regTm;
	private String updDt;
	private String updTm;

	public String getGdsCd() {
		return gdsCd;
	}
	public void setGdsCd(String gdsCd) {
		this.gdsCd = gdsCd;
	}
	public String getGdsType() {
		return gdsType;
	}
	public void setGdsType(String gdsType) {
		this.gdsType = gdsType;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getGdsImg() {
		return gdsImg;
	}
	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getEnabled() {
		return enabled;
	}
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getRegTm() {
		return regTm;
	}
	public void setRegTm(String regTm) {
		this.regTm = regTm;
	}
	public String getUpdDt() {
		return updDt;
	}
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	public String getUpdTm() {
		return updTm;
	}
	public void setUpdTm(String updTm) {
		this.updTm = updTm;
	}


}
