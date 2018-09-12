<jsp:include page="/includes/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 

<div style="width: 1030px;position: relative;left:140px">
	<div style="width: 220px;position: relative;">
		<img src="images/hioxindia-pharmacy_08.jpg" alt="" border="0" /> <br /> 
      	<h1>Pharmaceutist</h1>
      	<p>Freedesignertemplates.com has a wide collection of HTML web design templates.</p>
    	<p align="right"><a href="#" class="more">View More</a></p>
	</div>
	<div style="width: 300px;position: relative;top: -270px;left:240px">
		 <s:form action="doDistSelectOrder" method="post">
	           <table>
	            <tr><s:textfield label="Order ID" name="orderid" /></tr>
	            <tr><td><s:submit value="Submit" /></td>
	            <td> <s:reset value="Clear"/></td></tr></table>
	        </s:form>      
	</div>
	<div style="width: 220px;position: relative;top: -350px;left:500px">
		<img src="images/hioxindia-pharmacy_10.jpg" alt="" border="0" />
        <h1>Drug Store</h1>
      <p>Anyone can use these HTML templates just by replacing the content to the pre-existing site designs.</p>
	</div>	
	<div style="width: 220px;position: relative;top: -630px;left:740px">
		<img src="images/hioxindia-pharmacy_12.jpg" alt="" border="0" />
        <h1>Tablets</h1>
       <p>This high quality free pharmaceutical company template is built using XHTML and CSS..</p>
        <p align="right"><a href="#" class="more">View More</a></p>
	</div>	
</div>


<jsp:include page="/includes/footer3.jsp" />
