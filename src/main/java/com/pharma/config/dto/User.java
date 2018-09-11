package com.pharma.config.dto;

public class User {
	
	private String userName;
	private String password;
	private String repassword;
	private String disname;
	private String adderess;
	private String cityname;
	private String statename;
	private String countryName;
	private String region;
	private String email;
	private Long id;
	private String custPhoneNumber;
	
	
	
	public User() {
		super();
	}
	public User(String userName, String password, String adderess, String email, Long id, double phoneNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.adderess = adderess;
		this.email = email;
		this.id = id;
		this.phoneNo = phoneNo;
	}
	public String getCustPhoneNumber() {
		return custPhoneNumber;
	}
	public void setCustPhoneNumber(String custPhoneNumber) {
		this.custPhoneNumber = custPhoneNumber;
	}
	public Long getId() {
		return id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhoneNo(double phoneNo) {
		this.phoneNo = phoneNo;
	}
	private double phoneNo;
	
	
	public void setRegion(String region) {
		this.region = region;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getDisname() {
		return disname;
	}
	public void setDisname(String disname) {
		this.disname = disname;
	}
	public String getAdderess() {
		return adderess;
	}
	public void setAdderess(String adderess) {
		this.adderess = adderess;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getContryName() {
		return countryName;
	}
	public String getRegion() {
		return region;
	}
	public double getPhone() {
		return phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public boolean validate() {
		if(this.getUserName()!=null && this.getPassword()!=null && 
				this.getRepassword()!=null && this.getAdderess()!=null && 
						this.getStatename()!=null && this.getCityname()!=null && this.getRegion()!=null && 
						this.getContryName()!=null && this.getEmail() !=null && this.getPhone()!=0){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", repassword=" + repassword + ", disname="
				+ disname + ", adderess=" + adderess + ", cityname=" + cityname + ", statename=" + statename
				+ ", countryName=" + countryName + ", region=" + region + ", email=" + email + ", phoneNo=" + phoneNo
				+ "]";
	}
	public void setId(Long id) {
		this.id=id;
	}
	
	
	

}
