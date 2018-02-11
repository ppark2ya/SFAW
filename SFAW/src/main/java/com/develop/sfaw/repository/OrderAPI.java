package com.develop.sfaw.repository;

public class OrderAPI {

	private String txId;	// 트랜잭션 아이디 ( SFAW + currentTime + seq )
	private String ordNo;	// 주문 번호 ( OrdNo + colorCd + sizeCd + price + quantity )
	private String id;		// 구매자 아이디
	private String gdsCd;	// 상품 코드
	private int useCl;		// 상품 취소 여부 ( 0:주문, 1:취소 )
	private int enabled;	// 사용 가능 여부
	private int quantity;	// 주문 수량
	private String regDt;
	private String regTm;
	private String updDt;
	private String updTm;

	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGdsCd() {
		return gdsCd;
	}
	public void setGdsCd(String gdsCd) {
		this.gdsCd = gdsCd;
	}
	public int getUseCl() {
		return useCl;
	}
	public void setUseCl(int useCl) {
		this.useCl = useCl;
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
