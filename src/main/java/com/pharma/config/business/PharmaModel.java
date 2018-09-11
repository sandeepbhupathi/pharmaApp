package com.pharma.config.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.config.dao.PharmaDAO;
import com.pharma.config.dto.Order;
import com.pharma.config.dto.User;
import com.pharma.config.entity.CustOrders;
import com.pharma.config.entity.Customer;

@Service
public class PharmaModel {

	@Autowired
	private PharmaDAO pharmaDao;
	
	public boolean customerRegisteration(User user){
		Customer cust = new Customer();
		cust.setUserName(user.getUserName());
		cust.setPassword(user.getPassword());
		cust.setRePassword(user.getRepassword());
		cust.setDisName(user.getDisname());
		cust.setAddress(user.getAdderess());
		cust.setCityName(user.getCityname());
		cust.setStateName(user.getStatename());
		cust.setCityName(user.getContryName());
		cust.setRegion(user.getRegion());
		cust.setPhone(cust.getPhone());
		cust.setEmail(cust.getEmail());
		return pharmaDao.customerRegister(cust);
	}

	public boolean isValidLogon(User user) {
		return pharmaDao.isValidCustomerLogon(user);
	}

	public boolean createCustomerOrder(Order order) {
		CustOrders custOrder = new CustOrders();
		custOrder.setAmount(""+order.getAmount());
		custOrder.setDiscount(""+order.getDiscount());
		custOrder.setProdCode(order.getCode());
		custOrder.setProdName(order.getProductName());
		custOrder.setTax(""+order.getTax());
		custOrder.setMinq(""+order.getMinq());
		custOrder.setOrderq(""+order.getOrderq());
		custOrder.setNetcost(""+order.getNetCost());
		custOrder.setAmount(""+order.getAmount());
		custOrder.setPaymode(order.getModePay());
		return pharmaDao.createCustomerOrder(custOrder);
	}

	public boolean isValidAdminLogon(User user) {
		return pharmaDao.isValidAdminLogon(user);
	}

	public List<User> findAllCustomers() {
		List<User> userList= new ArrayList<User>();
		pharmaDao.findAllCustomers(null).forEach((cust)->{
			userList.add(new User(cust.getUserName(),cust.getPassword(),cust.getAddress(),
					cust.getEmail(),cust.getId(),cust.getPhone()!=null?Double.parseDouble(cust.getPhone()):0));
		});
		
		return userList;
	}

	public List<Order> findAllCustomersOrders() {
		List<Order> orderList = new ArrayList<>();
		pharmaDao.findAllCustomersOrders(null).forEach((order)->{
			orderList.add(new Order(order.getProdCode(),order.getId()+"",
									order.getOrderq().toString(),order.getMinq().toString(),
									order.getNetcost().toString(),order.getAmount().toString(),order.getProdName()));
		});
		return orderList;
	}

	public boolean deleteCustOrder(String orderid) {
		return pharmaDao.deleteCustOrder(orderid);
	}

	public boolean isOrderExists(String orderid) {
		return pharmaDao.findAllCustomersOrders(orderid).size()>0?true:false;
	}

	public boolean isCustmerExists(String custid) {
		return pharmaDao.findAllCustomers(custid).size()>0?true:false;
	}

	public boolean deleteCustomer(String custid) {
		return pharmaDao.deleteCustomer(custid);
	}

	public boolean isValidDistributerLogon(User user) {
		return pharmaDao.isValidDistributerLogon(user);
	}

	public Order findAllOrders(String orderid) {
		List<Order> orderList = new ArrayList<>();
		pharmaDao.findAllCustomersOrders(orderid).forEach((order)->{
			orderList.add(new Order(order.getProdCode(),order.getId()+"",
									order.getOrderq().toString(),order.getMinq().toString(),
									order.getNetcost().toString(),order.getAmount().toString(),order.getProdName()));
		});
		return orderList.get(0);
	}
}
