package com.pharma.config.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;
import com.pharma.config.dto.Order;

@Action("doAdminOrderUpdate")
@ResultPath("/")
@Results({ @Result(name = "success",
				location = "CustomerOrder.jsp",params={"orderidMsg","${orderidMsg}"}),
    @Result(name = "error", location = "Error.jsp")})
public class AdminCustomerUpdateOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @Autowired
	private PharmaModel model;

    private String orderid;
    private String orderidMsg;
    private Order order;
    

    public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
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
		  setOrder(model.findAllOrders(orderid));
		  return SUCCESS;
	  }else{
		  setOrderidMsg("Order is not exists in the system");
		  return SUCCESS;
	  }
	
	}

	
}
