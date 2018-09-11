package com.pharma.config.dto;

public class Order {
	private String code;
	private String productName;
	private double tax;
	private double minq;
	private double orderq;
	private double discount;
	private double netCost;
	private double amount;
	private String modePay;
	private String id;
	private String orderqStr;
	private String minqStr;
	private String netCostStr;
	private String amountStr;
	
	
	
	public Order() {
		super();
	}
	public Order(String code, String id, String orderqStr, String minqStr, String netCostStr, String amountStr,String prodName) {
		super();
		this.code = code;
		this.id = id;
		this.orderqStr = orderqStr;
		this.minqStr = minqStr;
		this.netCostStr = netCostStr;
		this.amountStr = amountStr;
		this.productName=prodName;
	}
	public String getAmountStr() {
		return amountStr;
	}
	public String setNetCostStr() {
		return netCostStr;
	}
	public String getMinqStr() {
		return minqStr;
	}
	public String getOrderqStr() {
		return orderqStr;
	}
	public String getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getMinq() {
		return minq;
	}
	public void setMinq(double minq) {
		this.minq = minq;
	}
	public double getOrderq() {
		return orderq;
	}
	public void setOrderq(double orderq) {
		this.orderq = orderq;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getNetCost() {
		return netCost;
	}
	public void setNetCost(double netCost) {
		this.netCost = netCost;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getModePay() {
		return modePay;
	}
	public void setModePay(String modePay) {
		this.modePay = modePay;
	}
	public void setId(String id) {
		this.id = id;
		
	}
	public void setOrderqStr(String orderqStr) {
		this.orderqStr = orderqStr;
		
	}
	public void setMinqStr(String minqStr) {
		this.minqStr = minqStr;
		
	}
	public void setNetCostStr(String netCostStr) {
		this.netCostStr = netCostStr;
		
	}
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
		
	}
	
	

}
