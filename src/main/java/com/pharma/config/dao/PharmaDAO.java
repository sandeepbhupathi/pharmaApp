package com.pharma.config.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pharma.config.dto.Order;
import com.pharma.config.dto.User;
import com.pharma.config.entity.Admin;
import com.pharma.config.entity.CustOrders;
import com.pharma.config.entity.Customer;
import com.pharma.config.entity.DistributerAdmin;

@Repository
@Transactional
public class PharmaDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean customerRegister(Customer cust){
		Session session = sessionFactory.getCurrentSession();
		session.save(cust);
		/*if (!session.getTransaction().equals(TransactionStatus.ACTIVE))
			session.getTransaction().commit();*/
		/*session.close();*/
		return true;
	}

	public boolean createCustomerOrder(CustOrders order) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		return true;
		
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAllCustomers(String custId) {
		String queryString = "from Customer a";
		if (custId != null) {
			queryString = queryString + " where a.id=:id";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(queryString, Customer.class);
		if (custId != null) {
			query.setParameter("id", Integer.parseInt(custId));
		}
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CustOrders> findAllCustomersOrders(String orderId) {
		String queryString = "from CustOrders a";
		if (orderId != null) {
			queryString = queryString + " where a.id=:id";
		}
		Query query = sessionFactory.getCurrentSession().createQuery(queryString, CustOrders.class);

		if (orderId != null) {
			query.setParameter("id", Long.parseLong(orderId));
		}

		return query.getResultList();
	}

	public boolean deleteCustOrder(String orderid) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete from CustOrders a where a.id=:id");
		query.setParameter("id", Long.parseLong(orderid));

		return query.executeUpdate() >= 1 ? true : false;
	}

	public boolean deleteCustomer(String custid) {
		Query query = sessionFactory.getCurrentSession().createQuery("delete from Customer a where a.id=:id");
		query.setParameter("id", Integer.parseInt(custid));

		return query.executeUpdate() >= 1 ? true : false;
	}

	public boolean isValidDistributerLogon(User user) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from DistributerAdmin a where a.userName=:uname and " + "a.password=:password",
				DistributerAdmin.class);

		query.setParameter("uname", user.getUserName());
		query.setParameter("password", user.getPassword());

		return query.getSingleResult() != null ? true : false;
	}

	public boolean isValidAdminLogon(User user) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Admin a where a.userName=:uname and " + "a.password=:password", Admin.class);

		query.setParameter("uname", user.getUserName());
		query.setParameter("password", user.getPassword());

		return query.getSingleResult() != null ? true : false;
	}
	
	public boolean isValidCustomerLogon(User user) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Customer a where a.userName=:uname and " + "a.password=:password", Customer.class);

		query.setParameter("uname", user.getUserName());
		query.setParameter("password", user.getPassword());

		return query.getSingleResult() != null ? true : false;

	}
}
