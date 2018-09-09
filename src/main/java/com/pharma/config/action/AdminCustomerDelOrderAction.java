package com.pharma.config.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;

@Action("doAdminCustDelOrder")
@ResultPath("/")
@Results({ @Result(name = "success", type="redirect",
				location = "doAdminCustOrder.action",params={"orderidMsg","${orderidMsg}"}),
    @Result(name = "error", location = "Error.jsp")})
public class AdminCustomerDelOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Autowired
	private PharmaModel model;

    private String orderid;
    private String orderidMsg;
    

	public String getOrderidMsg() {
		return orderidMsg;
	}

	public void setOrderidMsg(String orderidMsg) {
		this.orderidMsg = orderidMsg;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String execute() {
	  if(model.isOrderExists(orderid)){
		  setOrderidMsg("Order has been deleted");
		  if(model.deleteCustOrder(orderid)){
				return SUCCESS;
		  }else{
				return ERROR;
		  }
		  
	  }else{
		  setOrderidMsg("Order is not exists in the system");
		  return SUCCESS;
	  }
	
	}

	
}
