package com.pharma.config.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.pharma.config.business.PharmaModel;
import com.pharma.config.dto.Order;

@Action("doDistOrder")
@ResultPath("/")
@Results({ @Result(name = "success", location = "DistributerCustomerOrder.jsp"),
    @Result(name = "error", location = "Error.jsp")})
public class DistributerOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Order> orderList;
	
	public List<Order> getOrderList() {
		return orderList;
	}




	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}




	@Autowired
	private PharmaModel model;

	
	
	
	public String execute() {
		setOrderList(model.findAllCustomersOrders());
		/*if(model.isValidAdminLogon(user)){*/
			return SUCCESS;
		/*}else{
			return ERROR;
		}*/
	}

	
}
