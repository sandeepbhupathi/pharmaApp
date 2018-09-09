package com.pharma.config.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.config.dao.PharmaDAO;
import com.pharma.config.dto.Order;
import com.pharma.config.dto.User;

@Service
public class PharmaModel {

	@Autowired
	private PharmaDAO pharmaDao;
	
	public boolean customerRegisteration(User user){
		return pharmaDao.customerRegister(user);
	}

	public boolean isValidLogon(User user) {
		return pharmaDao.isValidCustomer(user);
	}

	public boolean createCustomerOrder(Order order) {
		return pharmaDao.createCustomerOrder(order);
	}

	public boolean isValidAdminLogon(User user) {
		return pharmaDao.isValidAdmin(user);
	}

	public List<User> findAllCustomers() {
		return pharmaDao.findAllCustomers();
	}

	public List<Order> findAllCustomersOrders() {
		return pharmaDao.findAllCustomersOrders(null);
	}

	public boolean deleteCustOrder(String orderid) {
		return pharmaDao.deleteCustOrder(orderid);
	}

	public boolean isOrderExists(String orderid) {
		return pharmaDao.isOrderExists(orderid);
	}

	public boolean isCustmerExists(String custid) {
		return pharmaDao.isCustemerExistins(custid);
	}

	public boolean deleteCustomer(String custid) {
		return pharmaDao.deleteCustomer(custid);
	}

	public boolean isValidDistributerLogon(User user) {
		return pharmaDao.isValidDistributerLogon(user);
	}

	public Order findAllOrders(String orderid) {
		return pharmaDao.findAllCustomersOrders(orderid).get(0);
	}
}
