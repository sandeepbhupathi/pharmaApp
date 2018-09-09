package com.pharma.config.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;
import com.pharma.config.dto.User;

@Action("doCustomerRegister")
@ResultPath("/")
@Results({ @Result(name = "success", location = "CustomerLogin.jsp"),
    @Result(name = "error", location = "Error.jsp"),
    @Result(name = "input", location = "CustomerRegister.jsp")})
public class CustomerRegisterAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	@Autowired
	private PharmaModel pharmaModel;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() {
		if(pharmaModel.customerRegisteration(user)){
			return SUCCESS;
		}else{
			return ERROR;
		}	
	}
	
	public void validate(){
		System.out.println(getUser());
	   if (getUser()!=null && !getUser().validate()) {
		   addActionError("Please Enter All Mandatory Fields");
	    }

	  /* if (getUser().getPassword().length() == 0) {
	        addFieldError("user.password", "Password is a Required Field");
	    }*/

	    /*if (personBean.getAge() < 18) {
	        addFieldError("personBean.age", "Age is required and must be 18 or older");
	    }*/
	}

}
