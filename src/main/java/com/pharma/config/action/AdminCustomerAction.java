package com.pharma.config.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;
import com.pharma.config.dto.User;

@Action("doAdminCust")
@ResultPath("/")
@Results({ @Result(name = "success", location = "AdminCustomer.jsp"), @Result(name = "error", location = "Error.jsp") })
public class AdminCustomerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<User> userList;
	private String custIdMsg;

	public String getCustIdMsg() {
		return custIdMsg;
	}

	public void setCustIdMsg(String custIdMsg) {
		this.custIdMsg = custIdMsg;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@Autowired
	private PharmaModel model;

	public String execute() {
		setUserList(model.findAllCustomers());
		/* if(model.isValidAdminLogon(user)){ */
		return SUCCESS;
		/*
		 * }else{ return ERROR; }
		 */
	}

}
