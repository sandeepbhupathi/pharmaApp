<jsp:include page="/includes/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

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
		<tr><s:if test='orderidMsg !=null'> <s:property value='orderidMsg'/> </s:if></tr>
		<td><a href='DistributerSelectOrder.jsp'>Orders</a></td>
		<tr><th>id</th><th>prodcode</th><th>productname</th><th>minquantity</th><th>orderqueue</th><th>Netcost</th><th>Amount</th></tr>
			<s:iterator value="orderList" >	
		    	<tr>
		    		<td><s:property value="id" /></td> 
		    		<td><s:property value="code"/></td>
		    		<td><s:property value="productName"/></td>
		    		<td><s:property value="minqStr"/></td>
		    		<td><s:property value="orderqStr"/></td>
		    		<td ><s:property value="netCostStr"/></td>
		    		<td ><s:property value="amountStr"/></td>
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
