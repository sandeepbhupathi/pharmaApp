package com.pharma.config.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pharma.config.dto.Order;
import com.pharma.config.dto.User;

@Repository
public class PharmaDAO {

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

	public boolean isValidCustomer(User user) {
		boolean status=false;
		Connection con=GetCon.getCon();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("Select * from NEWCUST4 where username = ? and password = ?");
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassword());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return status;
		
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

	public boolean isValidAdmin(User user) {

		boolean status=false;
		Connection con=GetCon.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from PHARMACYADMIN where username = ? and password = ?");
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassword());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<User> findAllCustomers() {
	 	List<User> userList = new ArrayList<User>();
	 	User eachUser = null;
		try {
			Connection con=GetCon.getCon();
			PreparedStatement ps=con.prepareStatement("Select * from newcust4");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				eachUser = new User();
				//int id=rs.getInt(1);
				eachUser.setId(rs.getInt(1));
				eachUser.setUserName(rs.getString(2));
				eachUser.setPassword(rs.getString(3));
				eachUser.setAdderess(rs.getString(6) );
				eachUser.setCustPhoneNumber(rs.getString(11));
				eachUser.setEmail(rs.getString(12));
				userList.add(eachUser);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	public List<Order> findAllCustomersOrders(String orderId) {
		List<Order> orderList = new ArrayList<Order>();
		Order eachorder=null;
		try{
			Connection con=GetCon.getCon();
			PreparedStatement ps;
			if(orderId!=null){
				ps=con.prepareStatement("Select * from neworder4 where id = '"+orderId+"'");
			}else{
				ps=con.prepareStatement("Select * from neworder4 ");
			}
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				eachorder = new Order();
				eachorder.setId(rs.getString(1));
				eachorder.setCode(rs.getString(2));
				eachorder.setProductName(rs.getString(3));
				eachorder.setMinqStr(rs.getString(5));
				eachorder.setOrderqStr(rs.getString(6));
				eachorder.setNetCostStr(rs.getString(8));
				eachorder.setAmountStr(rs.getString(9));
				orderList.add(eachorder);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return orderList;
	}

	public boolean deleteCustOrder(String orderid) {
		Connection con=GetCon.getCon();
		boolean state=false;
		try {
			PreparedStatement ps=con.prepareStatement("delete  from neworder4 where id = '"+orderid+"' ");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				state=true;
			}	 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	  	
		return state;
	}

	public boolean isOrderExists(String orderid) {
		Connection con=GetCon.getCon();
		boolean state=false;
		try {
			PreparedStatement ps=con.prepareStatement("select *  from neworder4 where id = '"+orderid+"' ");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				state=true;
			}	 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	  	
		return state;
	}

	public boolean isCustemerExistins(String custid) {
		Connection con=GetCon.getCon();
		boolean state=false;
		try {
			PreparedStatement ps=con.prepareStatement("select *  from newcust4 where id = '"+custid+"' ");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				state=true;
			}	 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	  	
		return state;
	}

	public boolean deleteCustomer(String custid) {
		Connection con=GetCon.getCon();
		boolean state=false;
		try {
			PreparedStatement ps=con.prepareStatement("delete  from newcust4 where id = '"+custid+"' ");
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				state=true;
			}	 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	  	
		return state;
	}

	public boolean isValidDistributerLogon(User user) {
		boolean status=false;
		Connection con=GetCon.getCon();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from DISTRIBUTERADMIN where username = ? and password = ?");
			ps.setString(1,user.getUserName());
			ps.setString(2,user.getPassword());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
