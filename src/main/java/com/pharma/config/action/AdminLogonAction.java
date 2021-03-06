package com.pharma.config.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;
import com.pharma.config.dto.User;

@Action("doAdminLogon")
@ResultPath("/")
@Results({ @Result(name = "success", location = "AdminProcess.jsp"),
    @Result(name = "error", location = "Error.jsp")})
public class AdminLogonAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	
	@Autowired
	private PharmaModel model;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String execute() {
		if(model.isValidAdminLogon(user)){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}

	
}
