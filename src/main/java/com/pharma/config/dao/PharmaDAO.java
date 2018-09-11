package com.pharma.config.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

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
	
	public boolean customerRegister(User user){
		Connection con=GetCon.getCon();
		PreparedStatement ps;
		int status = 0;
		try {
			ps = con.prepareStatement("Insert into NEWCUST4 values(?,?,?,?,?,?,?,?,?,?,?,?)");
			int	nextvalue1=GetCon.getPrimaryKey();
		 	ps.setInt(1,nextvalue1);
		    ps.setString(2,user.getUserName());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getRepassword());
			ps.setString(5,user.getDisname());
			ps.setString(6,user.getAdderess());
			ps.setString(7,user.getCityname());
			ps.setString(8,user.getStatename());
			ps.setString(9,user.getContryName());
			ps.setString(10,user.getRegion());
			ps.setDouble(11,user.getPhone());
			ps.setString(12,user.getEmail());
			
			status=ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status==1?true:false;
	}

	public boolean createCustomerOrder(Order order) {
		 Connection con=GetCon.getCon();
		 PreparedStatement ps;
		 boolean state=false;
		try {
			ps = con.prepareStatement("insert into neworder4 values(?,?,?,?,?,?,?,?,?,?)");
			 int nextvalue=GetCon.getPrimaryKey();
		 	 ps.setInt(1,nextvalue);
	         ps.setString(2,order.getCode());
	         ps.setString(3,order.getProductName());
	         ps.setDouble(4,order.getTax());
	         ps.setDouble(5,order.getMinq());
	         ps.setDouble(6,order.getOrderq());
	         ps.setDouble(7,order.getDiscount());
	         ps.setDouble(8,order.getNetCost());
	         ps.setDouble(9,order.getAmount());
	         ps.setString(10,order.getModePay());
	         ResultSet rs=ps.executeQuery();
	         state = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     
		return state; 
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
