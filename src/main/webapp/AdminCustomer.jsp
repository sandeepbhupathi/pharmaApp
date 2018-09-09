<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<jsp:include page="/includes/header.jsp" />

<div style="position: relative;top: 350px">
<div style="width: 960px;left:80px;height:350px;position: relative;">
	<div style="width: 30%;position: absolute;">
		<img src="images/hioxindia-pharmacy_08.jpg" alt="" border="0" /> <br /> 
      	<h1>Pharmaceutist</h1>
      	<p>Freedesignertemplates.com has a wide collection of HTML web design templates.</p>
    	<p align="right"><a href="#" class="more">View More</a></p>
	</div>
	<div style="width: 40%;position: absolute; left: 230px;">
		<table width="300" border="0" cellspacing="10" cellpadding="0" align="center">
		<tr><s:if test='custIdMsg !=null'> <s:property value='custIdMsg'/> </s:if></tr>
		<td><a href='AdminDeleteCustomer.jsp'>Delete</a></td>
		<tr><th>id</th><th>username</th><th>password</th><th>adderess</th><th>phone</th><th>Email</th></tr>
			<s:iterator value="userList" >	
		    	<tr>
		    		<td><s:property value="id" /></td> 
		    		<td><s:property value="userName"/></td>
		    		<td><s:property value="password"/></td>
		    		<td><s:property value="adderess"/></td>
		    		<td><s:property value="custPhoneNumber"/></td>
		    		<td width="20px"><s:property value="email"/></td>
		    	</tr>
		    </s:iterator>
		</table>
	</div>
	<div style="width: 30%;position: absolute;left: 830px;">
		<img src="images/hioxindia-pharmacy_10.jpg" alt="" border="0" />
        <h1>Drug Store</h1>
        <p>Anyone can use these HTML templates just by replacing the content to the pre-existing site designs.</p>
        <p align="right"><a href="#" class="more">View More</a></p>
	</div>	
</div>

<jsp:include page="/includes/footer3.jsp" />
