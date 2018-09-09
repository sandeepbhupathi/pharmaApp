package com.pharma.config.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;

@Action("doAdminCustDel")
@ResultPath("/")
@Results({ @Result(name = "success", type="redirect",
				location = "doAdminCust.action",params={"custIdMsg","${custIdMsg}"}),
    @Result(name = "error", location = "Error.jsp")})
public class AdminCustomerDelAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Autowired
	private PharmaModel model;

    private String custid;
    private String custIdMsg;
    
    
    public String getCustIdMsg() {
		return custIdMsg;
	}

	public void setCustIdMsg(String custIdMsg) {
		this.custIdMsg = custIdMsg;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}


	public String execute() {
	  if(model.isCustmerExists(custid)){
		  setCustIdMsg("Customer has been deleted");
		  if(model.deleteCustomer(custid)){
				return SUCCESS;
		  }else{
				return ERROR;
		  }
		  
	  }else{
		  setCustIdMsg("Customer is not exists in the system");
		  return SUCCESS;
	  }
	
	}

	
}
