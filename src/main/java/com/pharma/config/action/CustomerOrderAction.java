package com.pharma.config.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;
import com.pharma.config.dto.Order;

@Action("doCustomerOrder")
@ResultPath("/")
@Results({ @Result(name = "success", location = "CustomerOrderDetail.jsp"),
    @Result(name = "error", location = "Error.jsp"),
    @Result(name = "input", location = "CustomerOrder.jsp")})
public class CustomerOrderAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Order order;
	
	@Autowired
	private PharmaModel model;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String execute() {
		if(model.createCustomerOrder(order)){
			return SUCCESS;
		}else{
			return ERROR;
		}	
	}

}
