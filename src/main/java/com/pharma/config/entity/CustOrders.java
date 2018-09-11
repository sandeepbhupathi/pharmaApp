package com.pharma.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NEWORDER4")
public class CustOrders {
	
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "PRODCODE")
	private String prodCode;
	@Column(name = "PRODUCTNAME")
	private String prodName;
	@Column(name = "TAX")
	private String tax;
	@Column(name = "MINQ")
	private String minq;
	@Column(name = "ORDERQ")
	private String orderq;
	@Column(name = "DISCOUNT")
	private String discount;
	@Column(name = "NETCOST")
	private String netcost;
	@Column(name = "AMOUNT")
	private String amount;
	@Column(name = "PAYMODE")
	private String paymode;
	

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getMinq() {
		return minq;
	}
	public void setMinq(String minq) {
		this.minq = minq;
	}
	public String getOrderq() {
		return orderq;
	}
	public void setOrderq(String orderq) {
		this.orderq = orderq;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getNetcost() {
		return netcost;
	}
	public void setNetcost(String netcost) {
		this.netcost = netcost;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	
	
	

}
